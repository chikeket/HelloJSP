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