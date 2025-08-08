--게시글번호, 제목, 내용, 작성자, 조회수, 생성일자, 변경일자
create table tbl_board (
 board_no number, --게시글번호
 title    varchar2(100) not null, --글제목
 content  varchar2(1000) not null, --내용
 writer   varchar2(30) not null, --작성자
 view_cnt number default 0, --조회수
 creation_date date default sysdate, --데이터 생성 시점
 last_update_date date default sysdate -- 수정시점 저장
);
alter table tbl_board add constraint pk_board primary key(board_no);

create sequence board_seq;

insert into tbl_board (board_no,
                       title,
                       content,
                       writer)
values(board_seq.nextval,
       '게시글 등록',
       '게시글 등록 연습입니다',
       '홍길동');

insert into tbl_board (board_no,
                       title,
                       content,
                       writer)
values(board_seq.nextval,
       '등록 테스트',
       'HTML, CSS, Javascript 입니다',
       '김길동');
       
insert into tbl_board (board_no,
                       title,
                       content,
                       writer)
values(board_seq.nextval,
       '댓글등록되나요?',
       '기능을 만들겁니다',
       '박길동');       

UPDATE tbl_board
SET writer = '동동이5'    
where board_no = 5;

content = '작성6'
    writer = '동동이'
       
select *
from tbl_board
order by board_no;
--인덱스를 이용하면 쿼리 결과를 더 빨리 불러들일 수 있다
select /*+ INDEX_DESC(b PK_BOARD)*/ *
from tbl_board b;
order by board_no desc;

select ta.*
from (select /*+ INDEX_DESC(b PK_BOARD)*/ rownum rn, b.*
       from tbl_board b) ta
where ta.rn > (:page - 1) * 5
  and ta.rn <= :page * 5;

commit;

insert into tbl_board(board_no, title, content, writer)
select board_seq.nextval, title, content, writer
from tbl_board;

update tbl_board
set title =?,
    content = ?
where board_no = ?;

--25/07/31
--사용자 테이블,
--아이디, 비밀번호, 이름, 권한
create table tbl_member(
 member_id varchar2(100) primary key,
 member_pw varchar2(100) not null,
 member_name varchar2(50) not null,
 responsibility varchar2(10) default 'User' not null
);

insert into tbl_member (member_id, member_pw, member_name)
values('user01', '1111', '홍길동');

insert into tbl_member (member_id, member_pw, member_name, responsibility)
values('guest', '1111', '김관리', 'Admin');

select *
from tbl_board
order by board_no desc;

select *
from tbl_member
order by member_name;

update tbl_board
set writer = 'user02'
where board_no >=23;

select m.member_name, b.*
from tbl_board b
join tbl_member m
on b.writer = m.member_id
order by 1;

update tbl_member
set member_id = 'user03'
where member_id 'user02';

--25.08.01
alter table tbl_board add image varchar2(100);

--25.08.05
--댓글테이블(댓글번호, 원본글번호, 내용, 댓글작성자, 작성일시)
create table tbl_reply (
  reply_no number,
  board_no number not null,
  reply varchar2(500) not null,
  replyer varchar2(10) not null,
  reply_date date default sysdate
);
create sequence reply_seq;
alter table tbl_reply add constraint pk_reply primary key (reply_no);

insert into tbl_reply (reply_no, board_no, reply, replyer)
values(reply_seq.nextval, 149, '149번의 댓글입니다', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values(reply_seq.nextval, 148, '148번의 댓글입니다', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values(reply_seq.nextval, 147, '147번의 댓글입니다', 'user03');

select*
from tbl_reply;

update tbl_reply
set board_no = 147
where board_no = 149;

select reply_seq.nextval from dual;

--댓글 5개씩 페이징
select ta.*
from (select /*+ INDEX_DESC(b PK_REPLY)*/ rownum rn, b.*
      from tbl_reply b
      where b.board_no = 148
      
      ) ta
where ta.rn > (:page - 1) * 5        
  and ta.rn <= :page * 5;
  
  
  select b.* from (select /*+ INDEX_DESC(r PK_REPLY)*/ rownum rn, r.* 
                  from tbl_reply r where r.board_no = 148 ) b
                  where b.rn > (1 - 1) * 5 
                  and b.rn <= 1 * 5;
  
--페이지 건수 파악 질의
select count(1)       
from tbl_reply
where board_no = 148;


insert into tbl_reply (reply_no, board_no, reply, replyer)
select reply_seq.nextval, 148, '148번의 댓글입니다', 'user01'
from tbl_reply;

delete 
from tbl_reply
where reply_no >112;
--25-08-07
create table tbl_event (
title varchar(100) not null,
start_date varchar(20) not null,
end_date varchar(20)
);

insert into tbl_event (title, start_date, end_date)
values('미팅', '2025-09-08', '2025-09-09');

insert into tbl_event (title, start_date)
values('생일', '2025-09-18');

insert into tbl_event (title, start_date, end_date)
values('방학', '2025-09-15', '2025-09-18');

insert into tbl_event (title, start_date)
values('치과', '2025-09-14T18:00:00');

insert into tbl_event (title, start_date)
values('약먹자', '2025-09-16T07:20:00');

select title,
start_date as "start",
end_date
from tbl_event;