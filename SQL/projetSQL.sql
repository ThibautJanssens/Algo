DROP SCHEMA IF EXISTS projet CASCADE;
CREATE SCHEMA projet;

--creation of enumerate for table usage
CREATE TYPE projet.suspended_type AS ENUM('True','False','In danger');
CREATE TYPE projet.proposition_status AS ENUM ('On sale', 'Expired', 'Sold', 'Canceled');
CREATE TYPE projet.bid_status AS ENUM ('Won', 'Lost', 'Canceled');

--create user table
CREATE TABLE projet.users (
	user_id serial PRIMARY KEY,
	last_name varchar(50) NOT NULL CHECK (last_name != ''),
	first_name varchar(50) NOT NULL CHECK (first_name != ''),
	username varchar(50) NOT NULL CHECK (username != '') UNIQUE,
	pwd varchar(255) NOT NULL CHECK (pwd != ''),
	email varchar (50) NOT NULL CHECK (email SIMILAR TO '[a-zA-Z0-9_\-]+@([a-zA-Z0-9_\-]+\.[a-z]{2,4})') UNIQUE,
	suspended projet.suspended_type NOT NULL,
	avg_evaluation double precision NULL,
	salt varchar(255) NOT NULL CHECK (salt != ''),
	nb_item_sold integer NOT NULL
);

--table for object to sell
CREATE TABLE projet.propositions(
	proposition_id serial PRIMARY KEY,
	seller integer NOT NULL,
	expiration_date date CHECK (expiration_date > NOW()),
	description varchar(255),
	starting_price double precision NOT NULL CHECK (starting_price >= 0.0),
	status projet.proposition_status NOT NULL,
	FOREIGN KEY (seller) REFERENCES projet.users (user_id)
);

--table for evalutaion
CREATE TABLE projet.evaluations(
	evaluation_id serial PRIMARY KEY,
	comment varchar(255) NULL,
	date_eval TIMESTAMP NOT NULL,
	writer integer NOT NULL,
	concerned_person integer NOT NULL,
	score integer NOT NULL CHECK (score <= 5 or score > 0),
	item_sold integer NOT NULL,
	FOREIGN KEY (writer) REFERENCES projet.users (user_id),
	FOREIGN KEY (concerned_person) REFERENCES projet.users (user_id),
	FOREIGN KEY (item_sold) REFERENCES projet.propositions (proposition_id)
);

--table for bids
CREATE TABLE projet.bids(
	bid_id serial PRIMARY KEY,
	status projet.bid_status NOT NULL,
	bidder integer NOT NULL,
	price double precision NOT NULL CHECK (price >= 0.0),
	proposition integer NOT NULL,
	biding_date date NOT NULL,
	FOREIGN KEY (bidder) REFERENCES projet.users (user_id),
	FOREIGN KEY (proposition) REFERENCES projet.propositions (proposition_id)
);

--get the user targeted by an evaluation
CREATE VIEW projet.userConcernedEvaluation AS
	SELECT u.user_id AS "User id", u.last_name AS "Last name", u.first_name AS "First name", u.username AS "Username",
		u.email AS "Email", u.suspended AS "Suspended", u.avg_evaluation AS "Average evaluation", u.nb_item_sold AS "Number of items sold",
		e.concerned_person as "Concerned person"
	FROM projet.users u, projet.evaluations e
	WHERE e.concerned_person = u.user_id;

--get a user following a evaluation he made
CREATE VIEW projet.userWriterEvaluation AS
	SELECT u.user_id AS "User id", u.last_name AS "Last name", u.first_name AS "First name", u.username AS "Username",
		u.email AS "Email", u.suspended AS "Suspended", u.avg_evaluation AS "Average evaluation", u.nb_item_sold AS "Number of items sold",
		e.writer as "Writer"
	FROM projet.users u, projet.evaluations e
	WHERE e.writer = u.user_id;

--get an object targeted by an evaluation
CREATE VIEW projet.propositionEvaluation AS
    SELECT p.proposition_id AS "Proposition id", p.seller AS "Seller", p.expiration_date AS "Expiration date", p.description AS "Description",
        p.starting_price AS "Starting price", p.status AS "Status", e.item_sold AS "Item sold"
    FROM projet.evaluations e, projet.propositions p
    WHERE e.item_sold = p.proposition_id;

--get a user following an object avaible to buy
CREATE VIEW projet.userProposition AS
	SELECT u.user_id, u.last_name AS "Last name", u.first_name AS "First name", u.username AS "Username",
		u.email AS "Email", u.suspended AS "Suspended", u.avg_evaluation AS "Average evaluation", u.nb_item_sold AS "Number of items sold",
		p.proposition_id AS "Proposition id", p.seller, p.expiration_date AS "Expiration date", p.description AS "Description",
		p.starting_price AS "Starting price", p.status
	FROM projet.users u, projet.propositions p
	WHERE p.seller = u.user_id;

--get a user following his bid
CREATE VIEW projet.userBid AS
	SELECT u.user_id AS "User id", u.last_name AS "Last name", u.first_name AS "First name", u.username AS "Username",
		u.email AS "Email", u.suspended AS "Suspended", u.avg_evaluation AS "Average evaluation", u.nb_item_sold AS "Number of items sold",
		b.bidder AS "Bidder"
	FROM projet.users u, projet.bids b
	WHERE b.bidder = u.user_id;

--get an object thanks to the bid
CREATE VIEW projet.propositionBid AS
    SELECT p.proposition_id AS "Proposition id", p.seller AS "Seller", p.expiration_date AS "Expiration date", p.description AS "Description",
        p.starting_price AS "Starting price", p.status AS "Status", b.proposition AS "Proposition"
    FROM projet.bids b, projet.propositions p
    WHERE b.proposition = p.proposition_id;

--get an evaluation and the bids linked with it
CREATE VIEW projet.bidsEval AS
	SELECT b.bid_id AS "Bid id", b.status as "Status", b.bidder AS "Bidder", b.price AS "Price", b.proposition AS "Proposition", b.biding_date AS "Biding date",
		e.comment AS "Comment", e.date_eval AS "Date evaluation", e.writer AS "Writer", e.concerned_person AS "Concerned person", e.score AS "Score"
	FROM projet.bids b, projet.evaluations e, projet.propositions p
	WHERE b.proposition = p.proposition_id AND p.proposition_id = e.item_sold;

--get all the id and username of all users
CREATE VIEW projet.userIdUsername AS
    SELECT u.user_id AS "User Id", u.username AS "Username"
    FROM projet.users u
	ORDER BY u.user_id;

--get all evaluation and give the username of the user who made it
CREATE VIEW projet.userWriterAndEvaluation AS
	SELECT e.evaluation_id AS "Evaluation id", e.comment AS "Comment", e.score AS "Score", e.item_sold AS "Item Sold",
         e.date_eval AS "Date Evaluation", u.username AS "Username_concerned", u2.user_id
	FROM projet.evaluations e, projet.users u, projet.users u2
	WHERE e.writer = u.user_id AND e.concerned_person = u2.user_id;

--get all evaluation and give the username of the user who received it
CREATE VIEW projet.userConcernedAndEvaluation AS
	SELECT e.evaluation_id AS "Evaluation id", e.comment AS "Comment", e.score AS "Score", e.item_sold AS "Item Sold",
         e.date_eval AS "Date Evaluation", u2.username AS "Username_writer", u.user_id
	FROM projet.evaluations e, projet.users u, projet.users u2
	WHERE e.writer = u.user_id AND e.concerned_person = u2.user_id;

--get everything of an evalution and a bid, if evaluation is at 'Sold' state and the bid is at 'Won' state
CREATE VIEW projet.propositionSoldAndBidWon AS
	SELECT b.bid_id AS "Bid id", b.status as "Status Bid", b.bidder AS "Bidder", b.price AS "Price", b.proposition AS "Proposition", b.biding_date AS "Biding date",
		p.proposition_id AS "Proposition id", p.seller , p.expiration_date AS "Expiration date", p.description AS "Description",
		p.starting_price AS "Starting price", p.status AS "Status Proposition", u2.username
	FROM projet.propositions p, projet.bids b, projet.users u, projet.users u2
	WHERE b.proposition = p.proposition_id AND b.status = 'Won' AND p.status = 'Sold' AND u.user_id = p.seller AND u2.user_id = b.bidder AND u.user_id != u2.user_id;

--get all bids of an evaluation for a user
CREATE VIEW projet.bidsProposition AS
	SELECT b.bid_id AS "Bid id", p.status, b.bidder AS "Bidder", b.price AS "Price", b.proposition AS "Proposition", b.biding_date AS "Biding date",
		p.description, u2.user_id, u2.username, p.starting_price, p.seller
	FROM projet.propositions p, projet.bids b,projet.users u, projet.users u2
	WHERE b.proposition = p.proposition_id AND u.user_id = p.seller AND u.user_id != u2.user_id AND b.bidder = u2.user_id;

--function to insert new user
CREATE OR REPLACE FUNCTION projet.addUser(VARCHAR(50), VARCHAR(50), VARCHAR(50), VARCHAR(50), VARCHAR(50), VARCHAR(255)) RETURNS INTEGER AS $$
	DECLARE
		id INTEGER = 0;
		last_name ALIAS FOR $1;
		first_name ALIAS FOR $2;
		username ALIAS FOR $3;
		pwd ALIAS FOR $4;
		email ALIAS FOR $5;
		salt ALIAS FOR $6;
	BEGIN
		INSERT INTO projet.users
		VALUES (DEFAULT, last_name, first_name, username, pwd, email, 'False', null, salt, 0) RETURNING user_id INTO id;
		RETURN id;
END;
$$ LANGUAGE plpgsql;

--function to insert a new object to sell
CREATE OR REPLACE FUNCTION projet.addProposition(INTEGER, DATE, VARCHAR(255), DOUBLE PRECISION) RETURNS INTEGER AS $$
	DECLARE
		id INTEGER = 0;
		seller ALIAS FOR $1;
		expiration_date ALIAS FOR $2;
		description ALIAS FOR $3;
		starting_price ALIAS FOR $4;
	BEGIN
		INSERT INTO projet.propositions
		VALUES (DEFAULT, seller, expiration_date, description, starting_price, 'On sale') RETURNING proposition_id INTO id;
		RETURN id;
END;
$$ LANGUAGE plpgsql;

--function to insert a new evaluation
CREATE OR REPLACE FUNCTION projet.addEvaluation(VARCHAR(255),INTEGER, INTEGER, INTEGER, INTEGER) RETURNS INTEGER AS $$
	DECLARE
		id INTEGER = 0;
		commentary ALIAS FOR $1;
		writer ALIAS FOR $2;
		concerned_person ALIAS FOR $3;
		score ALIAS FOR $4;
		item_sold ALIAS FOR $5;
	BEGIN
		IF(commentary = '')THEN
			commentary = NULL;
		END IF;
		INSERT INTO projet.evaluations
		VALUES (DEFAULT, commentary, NOW(), writer, concerned_person, score, item_sold) RETURNING evaluation_id INTO id;
		RETURN id;
	END;
$$ LANGUAGE plpgsql;

--function to insert a new bid
CREATE OR REPLACE FUNCTION projet.addBid(INTEGER, DOUBLE PRECISION, INTEGER) RETURNS INTEGER AS $$
	DECLARE
		id INTEGER = 0;
		bidder ALIAS FOR $1;
		price ALIAS FOR $2;
		proposition ALIAS FOR $3;
	BEGIN
		INSERT INTO projet.bids
		VALUES (DEFAULT, 'Lost', bidder, price, proposition, NOW()) RETURNING bid_id INTO id;
		RETURN id;
	END;
$$ LANGUAGE plpgsql;

--allow the modificatin of an object if not bid is on it
CREATE OR REPLACE FUNCTION projet.modifyProposition(INTEGER, INTEGER, DATE, VARCHAR(255), DOUBLE PRECISION) RETURNS INTEGER AS $$
	DECLARE
		id_u ALIAS FOR $1;
		id_p ALIAS FOR $2;
		expi_date ALIAS FOR $3;
		descr ALIAS FOR $4;
		st_pr ALIAS FOR $5;
	BEGIN
		UPDATE projet.propositions SET seller = id_u, starting_price = st_pr, description = descr, expiration_date = expi_date
		FROM projet.propositions p WHERE id_p = p.proposition_id;
		RETURN id_p;
	END;
$$ LANGUAGE plpgsql;

--allow to unban a user
CREATE OR REPLACE FUNCTION projet.unbanUser(INTEGER) RETURNS INTEGER AS $$
    DECLARE
        id_u ALIAS FOR $1;
    BEGIN
        IF NOT EXISTS(SELECT * FROM projet.users WHERE id_u = user_id)THEN
            RAISE 'No user with this id';
        ELSE
            UPDATE projet.users SET suspended = 'False' WHERE id_u = user_id;
        END IF;
        RETURN id_u;
    END;
$$ LANGUAGE plpgsql;

--change status of an object to 'sold' and a bid to 'won'
CREATE OR REPLACE FUNCTION projet.win(INTEGER, INTEGER) RETURNS INTEGER AS $$
	DECLARE
		id_b ALIAS FOR $1;
		id_p ALIAS FOR $2;
	BEGIN
		UPDATE projet.bids SET status = 'Won' WHERE proposition = id_p AND bid_id = id_b;
		UPDATE projet.propositions SET status = 'Sold' WHERE proposition_id = id_p;
		RETURN id_p;
	END;

$$ LANGUAGE plpgsql;

--increment the nombre of sold item by user at insertion of a new item to sell
CREATE OR REPLACE FUNCTION projet.itemSoldUpdate() RETURNS TRIGGER AS $$
	BEGIN
		UPDATE projet.users SET nb_item_sold = nb_item_sold+1 WHERE NEW.seller = user_id;
		RETURN NEW;
	END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_itemSoldUpdate AFTER INSERT ON projet.propositions FOR EACH ROW
	EXECUTE PROCEDURE projet.itemSoldUpdate();

--check if an insert of an evaluation if on an ended bid (and so the item sold)
CREATE OR REPLACE FUNCTION projet.checkOnInsertEval() RETURNS TRIGGER AS $$
	DECLARE
		status_bid projet.bid_status;
		status_prop projet.proposition_status;
	BEGIN
		SELECT "Status" FROM projet.propositionEvaluation WHERE "Item sold" = NEW.item_sold INTO status_prop;
		IF(status_prop != 'Sold')THEN
			raise 'Item not sold yet';
		END IF;
		SELECT "Status" FROM projet.bidsEval WHERE NEW.item_sold = "Proposition" INTO status_bid;
		IF(status_bid != 'Won')THEN
			RAISE 'The bid is not won';
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_insertEval BEFORE INSERT ON projet.evaluations FOR EACH ROW
	EXECUTE PROCEDURE projet.checkOnInsertEval();

--check if the price of the bid is >= to the item's price
CREATE OR REPLACE FUNCTION projet.checkOnInsertBid() RETURNS TRIGGER AS $$
	DECLARE
		stpr double precision;
	BEGIN
		SELECT starting_price FROM projet.propositions WHERE NEW.proposition = proposition_id INTO stpr;
		IF(stpr > NEW.price)THEN
			RAISE 'Price lower than the starting one.';
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_insertBid BEFORE INSERT ON projet.bids FOR EACH ROW
	EXECUTE PROCEDURE projet.checkOnInsertBid();

--update of the state 'suspended' for a user and his average score after a evaluation
CREATE OR REPLACE FUNCTION projet.modifyAvgEval() RETURNS TRIGGER AS $$
	DECLARE
		note double precision;
		final_state projet.suspended_type = 'False';
		state projet.suspended_type;
	BEGIN
		IF (NEW.score = 1) THEN
			SELECT "Suspended" FROM projet.userConcernedEvaluation
			WHERE "Concerned person" = NEW.concerned_person INTO state;

			IF (state = 'In danger') THEN
				final_state = 'True';
			ELSIF(state = 'False') THEN
				final_state = 'In danger';
			END IF;
		END IF;

		SELECT avg(score) FROM projet.evaluations
		WHERE concerned_person = NEW.concerned_person INTO note;

		UPDATE projet.users SET avg_evaluation = note, suspended = final_state WHERE user_id = NEW.concerned_person;
		RETURN NEW;
	END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_eval AFTER INSERT ON projet.evaluations FOR EACH ROW
	EXECUTE PROCEDURE projet.modifyAvgEval();

--update an object status to 'canceled' when a user is banned 
--and all bids on this item are set to lost
CREATE OR REPLACE FUNCTION projet.modifyPropositionStatus() RETURNS TRIGGER AS $$
	DECLARE
		user_state projet.suspended_type;
	BEGIN
		SELECT NEW.suspended FROM projet.users INTO user_state;
		IF(user_state = 'True')THEN
			UPDATE projet.propositions SET status = 'Canceled' WHERE seller = NEW.user_id AND status = 'On sale';
			UPDATE projet.bids SET status = 'Canceled' WHERE bidder = NEW.user_id AND status = 'Lost';
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_user AFTER UPDATE ON projet.users FOR EACH ROW
	EXECUTE PROCEDURE projet.modifyPropositionStatus();

--update all the bids to canceled when an object being sell is canceled
--check also when an object is being modified if there is no bids are on it
CREATE OR REPLACE FUNCTION projet.cancelBid() RETURNS TRIGGER AS $$
	DECLARE
		proposition_state projet.proposition_status;
		seller INTEGER;
	BEGIN
		SELECT NEW.status FROM projet.propositions INTO proposition_state;
		IF(proposition_state = 'Canceled')THEN
			UPDATE projet.bids SET status = 'Canceled' WHERE proposition = NEW.proposition_id;
		ELSIF(proposition_state = 'Expired')THEN
			UPDATE projet.bids SET status = 'Lost' WHERE proposition = NEW.proposition_id;
		ELSIF(proposition_state = 'Sold')THEN
			IF(1 = (SELECT COUNT(*) FROM projet.propositionBid
				WHERE "Proposition" = NEW.proposition_id AND "Status" = 'Sold')) THEN
				RAISE 'There is already a winning bid';
			END IF;
		ELSE
			SELECT seller FROM projet.propositions WHERE proposition_id = NEW.proposition_id INTO seller;
			IF EXISTS (SELECT * FROM projet.propositionBid
					WHERE "Proposition" = NEW.proposition_id) THEN
				RAISE 'There are bids on this item';
			ELSIF(seller != NEW.seller) THEN
				RAISE 'Evalutation made by an another user';
			END IF;
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_propositionUpdate BEFORE UPDATE ON projet.propositions FOR EACH ROW
	EXECUTE PROCEDURE projet.cancelBid();

REVOKE ALL
ON SCHEMA projet
FROM aterryn15;

GRANT CONNECT
ON DATABASE dbtjansse15
TO aterryn15;

GRANT USAGE
ON SCHEMA projet
TO aterryn15;

GRANT SELECT, UPDATE
ON projet.users
TO aterryn15;

GRANT SELECT, INSERT, UPDATE
ON projet.bids
TO aterryn15;

GRANT SELECT
ON projet.propositionsoldandbidwon
TO aterryn15;

GRANT SELECT, UPDATE, INSERT
ON projet.propositions
TO aterryn15;

GRANT SELECT
ON projet.userconcernedandevaluation
TO aterryn15;

GRANT SELECT
ON projet.userwriterandevaluation
TO aterryn15;

GRANT SELECT
ON projet.userproposition
TO aterryn15;

GRANT SELECT
ON projet.bidsproposition
TO aterryn15;

GRANT INSERT, SELECT
ON projet.evaluations
TO aterryn15;

GRANT USAGE
ON SEQUENCE projet.bids_bid_id_seq
TO aterryn15;

GRANT USAGE
ON SEQUENCE projet.evaluations_evaluation_id_seq
TO aterryn15;

GRANT SELECT
ON projet.propositionBid
TO aterryn15;

GRANT SELECT
ON projet.propositionevaluation
TO aterryn15;

GRANT SELECT
ON projet.bidseval
TO aterryn15;

GRANT SELECT
ON projet.userconcernedevaluation
TO aterryn15;

-- tests
INSERT INTO projet.users VALUES (DEFAULT, 'Terryn', 'Arnaud', 'Sukinja', 'rofl', 'email1@hotmail.fr', 'False', NULL, 'Salt', 0);
INSERT INTO projet.users VALUES (DEFAULT, 'Janssens', 'Thibaut', 'Bicky', 'lmao', 'email2@gmail.com', 'False', NULL, 'Salt', 0);
INSERT INTO projet.propositions VALUES (DEFAULT, 1, '2017-12-30 10:02:30', 'amazing item', 100, 'Sold');
INSERT INTO projet.propositions VALUES (DEFAULT, 1, '2017-12-31 10:02:30', 'nice item', 50, 'On sale');
INSERT INTO projet.propositions VALUES (DEFAULT, 2, '2017-12-31 10:02:30', 'average item', 25, 'On sale');
INSERT INTO projet.bids VALUES (DEFAULT,'Won',2 ,150, 1, NOW());
INSERT INTO projet.evaluations VALUES (DEFAULT, 'Ui', NOW(), 2, 1, 5, 1);
INSERT INTO projet.evaluations VALUES (DEFAULT, 'amazing comment', NOW(), 1, 2, 5, 1);
SELECT projet.addUser('last_name', 'first_name', 'username', 'password', 'email@email.fr', 'salt');
SELECT projet.addProposition(1, '2017-12-15 10:00:00', 'love dogs', 152.3);
SELECT projet.addBid(3, 50, 2);
SELECT projet.addBid(1, 30, 3);
SELECT projet.addEvaluation('meh',3, 1, 1, 2);

/*
select of table - check of insertion-

SELECT * FROM projet.userProposition
SELECT * FROM projet.users
SELECT * FROM projet.propositions
SELECT * FROM projet.evaluations
SELECT * FROM projet.bids
*/
