-- dangol.members definition

CREATE TABLE `members` (
  `mid` varchar(20) NOT NULL COMMENT '회원ID',
  `mpw` varchar(20) NOT NULL COMMENT '회원PW',
  `mphone` varchar(20) NOT NULL COMMENT '회원전화번호',
  `maddress` varchar(40) NOT NULL COMMENT '회원주소',
  `maddress_d` varchar(500) NOT NULL COMMENT '상세주소',
  `mgender` varchar(2) NOT NULL COMMENT '회원성별(M/F)',
  `mjob` varchar(25) DEFAULT NULL COMMENT '회원직업',
  `mtype` varchar(10) NOT NULL DEFAULT 'MEMBER' COMMENT '회원유형 (ADMIN/MEMBER)',
  `marea1` varchar(40) DEFAULT NULL COMMENT '회원선호지역1',
  `marea2` varchar(40) DEFAULT NULL COMMENT '회원선호지역2',
  `mimage` varchar(50) DEFAULT NULL COMMENT '회원이미지',
  `mpenalty` int(1) NOT NULL DEFAULT '0' COMMENT '회원예약취소시 패널티',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- dangol.admins definition

CREATE TABLE `admins` (
  `anum` int(10) NOT NULL AUTO_INCREMENT COMMENT '관리번호',
  `atype` varchar(6) NOT NULL DEFAULT 'M1' COMMENT '분류( TA - taste , FO- food ,TH - theme, M1 - main1, M2 - main2 )',
  `avalue` varchar(50) NOT NULL DEFAULT '0' COMMENT '값',
  `aimage` varchar(50) DEFAULT NULL COMMENT '음식이미지',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`anum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- dangol.mtag definition

CREATE TABLE `mtag` (
  `mtnum` int(10) NOT NULL AUTO_INCREMENT COMMENT '회원태그번호',
  `mid` varchar(20) NOT NULL COMMENT '회원아이디',
  `anum` int(10) NOT NULL COMMENT '관리번호',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`mtnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- dangol.boss definition

CREATE TABLE `boss` (
  `bid` varchar(20) NOT NULL COMMENT '사장님아이디',
  `bpw` varchar(20) NOT NULL COMMENT '사장님비밀번호',
  `bphone` varchar(20) NOT NULL COMMENT '사장님개인번호',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- dangol.stores definition

CREATE TABLE `stores` (
  `snum` int(10) NOT NULL AUTO_INCREMENT COMMENT '가게번호',
  `bid` varchar(20) NOT NULL COMMENT '사장님아이디',
  `sintro` varchar(50) DEFAULT NULL COMMENT '가게소개글',
  `sname` varchar(100) NOT NULL COMMENT '가게이름',
  `saddress` varchar(40) NOT NULL COMMENT '가게주소',
  `sdetailaddr` varchar(40) DEFAULT NULL COMMENT '가게상세주소',
  `sphone` varchar(20) NOT NULL COMMENT '가게전화번호',
  `stime` varchar(30) DEFAULT NULL COMMENT '영업시간',
  `sparking` varchar(2) NOT NULL DEFAULT 'N' COMMENT '주차여부( Y / N )',
  `simage` varchar(50) DEFAULT NULL COMMENT '가게이미지',
  `stype` varchar(20) NOT NULL COMMENT '업종분류(음식)',
  `sholiday` varchar(30) NOT NULL COMMENT '휴무일(MO,TU,WE,TH,FR,SA,SU)',
  `sratelv0` int(1) NOT NULL DEFAULT '0' COMMENT '등급0 할인율',
  `sratelv1` int(1) NOT NULL DEFAULT '0' COMMENT '등급1 할인율',
  `sratelv2` int(1) NOT NULL DEFAULT '0' COMMENT '등급2 할인율',
  `sratelv3` int(1) NOT NULL DEFAULT '0' COMMENT '등급3 할인율',
  `slimit` int(5) DEFAULT '0' COMMENT '예약가능 최대인원',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`snum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- dangol.stag definition

CREATE TABLE `stag` (
  `stnum` int(10) NOT NULL AUTO_INCREMENT COMMENT '가게태그번호',
  `snum` int(10) NOT NULL COMMENT '가게번호',
  `anum` int(10) NOT NULL COMMENT '관리번호',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자',  
  PRIMARY KEY (`stnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- dangol.grades definition

CREATE TABLE `grades` (
  `gnum` int(10) NOT NULL AUTO_INCREMENT COMMENT '등급번호',
  `mid` varchar(20) DEFAULT NULL COMMENT '회원아이디',
  `snum` int(10) DEFAULT NULL COMMENT '가게번호',
  `glevel` int(1) DEFAULT '0' COMMENT '등급',
  `gcurrent` varchar(5) NOT NULL DEFAULT 'N' COMMENT '현재 등급 확인 (Y/N)',
  `glike` int(1) DEFAULT '0' COMMENT '좋아요',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자',   
  PRIMARY KEY (`gnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- dangol.details definition

CREATE TABLE `details` (
  `dnum` int(10) NOT NULL AUTO_INCREMENT COMMENT '내역번호',
  `gnum` int(10) DEFAULT NULL COMMENT '등급번호',
  `ddate` datetime NOT NULL COMMENT '예약날짜 OR 혜택받은 날짜',
  `dperson` int(10) DEFAULT NULL COMMENT '예약인원',
  `dmenu` varchar(50) DEFAULT NULL COMMENT '예약메뉴',
  `dtype` varchar(10) NOT NULL DEFAULT 'N' COMMENT '예약여부 (Y/N)',
  `dask` varchar(100) DEFAULT NULL COMMENT '요구사항',
  `dcheck` varchar(5) NOT NULL DEFAULT 'N' COMMENT '결제여부 (Y/N)',
  `dtime` varchar(15) DEFAULT NULL COMMENT '예약시간',
  `dcount` int(10) DEFAULT '0' COMMENT '후기횟수',
  `dlimit` int(10) DEFAULT NULL COMMENT '사용자 예약 시 비교대상이 되는 예약 가능 최대 인원',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자', 
  PRIMARY KEY (`dnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- dangol.inquirys definition

CREATE TABLE `inquirys` (
  `inum` int(10) NOT NULL AUTO_INCREMENT COMMENT '문의번호',
  `mid` varchar(20) DEFAULT NULL COMMENT '회원아이디',
  `bid` varchar(20) DEFAULT NULL COMMENT '사장님아이디',
  `itype` varchar(10) NOT NULL COMMENT '문의유형(SV - service, ST - site)',
  `ititle` varchar(50) NOT NULL COMMENT '문의제목',
  `icontent` varchar(150) NOT NULL COMMENT '문의내용',
  `idate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '문의날짜',
  `istate` varchar(5) NOT NULL DEFAULT 'N' COMMENT '답변상태(Y/N)',
  `ianswer` varchar(150) DEFAULT NULL COMMENT '답변내용',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자', 
  PRIMARY KEY (`inum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- dangol.comments definition

CREATE TABLE `comments` (
  `cnum` int(10) NOT NULL AUTO_INCREMENT COMMENT '리뷰번호',
  `dnum` int(10) DEFAULT NULL COMMENT '내역번호',
  `ctotal` int(1) DEFAULT '0' COMMENT '총점(0~5)',
  `ctaste` varchar(35) DEFAULT NULL COMMENT '맛 태그',
  `cservice` int(1) DEFAULT '0' COMMENT '서비스 별점(0~5)',
  `cprice` int(1) DEFAULT '0' COMMENT '가격 별점(0~5)',
  `creview` varchar(100) DEFAULT NULL COMMENT '리뷰내용',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자',
  PRIMARY KEY (`cnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- dangol.orders definition

CREATE TABLE `orders` (
  `onum` int(10) NOT NULL AUTO_INCREMENT COMMENT '메뉴번호',
  `snum` int(10) DEFAULT NULL COMMENT '가게번호',
  `oname` varchar(30) NOT NULL COMMENT '메뉴이름',
  `oprice` int(10) NOT NULL DEFAULT '0' COMMENT '메뉴가격',
  `oimage` varchar(50) DEFAULT NULL COMMENT '메뉴이미지',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자',  
  PRIMARY KEY (`onum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- dangol.events definition

CREATE TABLE `events` (
  `eid` int(10) NOT NULL AUTO_INCREMENT COMMENT '이벤트번호',
  `snum` int(10) DEFAULT NULL COMMENT '가게번호',
  `etitle` varchar(50) NOT NULL COMMENT '이벤트제목',
  `estartdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '이벤트시작날짜',
  `eenddate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '이벤트종료날짜',
  `etarget` varchar(20) NOT NULL COMMENT '이벤트대상',
  `eimage` varchar(50) NOT NULL COMMENT '이벤트내용이미지',
  `regist_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일자',
  `modify_dt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일자',
  `regist_id` varchar(100) NOT NULL COMMENT '등록자',
  `modify_id` varchar(100) NOT NULL COMMENT '수정자',    
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;