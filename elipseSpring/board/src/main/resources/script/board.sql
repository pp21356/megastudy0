--sequence 생성
CREATE SEQUENCE seq_board;

--table 생성
CREATE TABLE tb1_board
(
	bno number(10),
	title varchar2(200) NOT NULL,
	content varchar2(2000) NOT NULL,
	writer varchar(50) NOT NULL,
	regdate DATE DEFAULT sysdate,
	updatedate DATE DEFAULT sysdate
);

--primary Key 생성
ALTER TABLE tb1_board ADD CONSTRAINT PK_BOARD PRIMARY KEY(bno);

SELECT * FROM tb1_board;

INSERT INTO tb1_board(bno, title, content, writer) 
values(seq_board.nextval, '테스트 제목', '테스트 내용', 'admin');

select bno, title, content, writer, regdate, updatedate
		from(
				select /*+ index_desc(tb PK_BOARD) */ 
					rownum rn, bno, title, content, writer ,regdate, updatedate
				from tb1_board tb 
				where bno > 0
				and rownum <= 1*2	
			)
		where rn>(1-1)*2
		
		
		
		
SELECT * FROM TB1_REPLY ;




-- 첨부파일 테이블 생성
CREATE TABLE tb1_attach(
	uuid  varchar2(100) NOT NULL,
	uploadpath varchar2(200) not NULL,
	filename varchar2(100) NOT NULL,
	image varchar2(1),	/*이미지이면 1,아니면 0 */
	bno number(10)
);

ALTER TABLE TB1_ATTACH ADD CONSTRAINT PK_ATTACH PRIMARY key(uuid);
SELECT * FROM tb1_attach;
