-- Adminer 4.8.1 PostgreSQL 14.1 dump

DROP TABLE IF EXISTS "sample";
CREATE TABLE "public"."sample" (
    "order_no" integer NOT NULL,
    "order_item" text NOT NULL
);

INSERT INTO "sample" ("order_no", "order_item") VALUES
(2,'おにく'),
(1,'さかな'),
(3,'たまご');

DROP TABLE IF EXISTS "sample_ref";
CREATE TABLE "public"."sample_ref" (
    "order_no" integer NOT NULL,
    "order_ref_no" integer NOT NULL,
    "order_detail_comment" text NOT NULL
) WITH (oids = false);

INSERT INTO "sample_ref" ("order_no", "order_ref_no", "order_detail_comment") VALUES
(1,1,'あああ'),
(3,1,'ううう'),
(2,3,'にくのはなまさ'),
(2,1,'やきにくてんごく'),
(2,2,'おにく');

-- 2022-01-04 04:27:20.409888+00
