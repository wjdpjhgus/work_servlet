package com.koitt.board.vo;

import java.io.Serializable;
import java.util.Date;

// Java Bean, VO(Value Object), DTO(Data Transfer Object)
public class Board implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer no;		// 글 번호
	private String title;	// 글 제목
	private String content;	// 글 내용
	private String writer;	// 글 작성자
	private Date regdate;	// 등록일
	
	// 1. 기본생성자
	public Board() {}

	// 2. 생성자 (모든 필드 초기화)
	public Board(Integer no, String title, String content, String writer, Date regdate) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}

	// 3. getter, setter
	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	// 3. hashCode
	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((regdate == null) ? 0 : regdate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
		return result;
	}

	// 4. equals
	@Override
	public boolean equals(Object obj) {
		// 4-1. 주소 비교
		if (this == obj) {
			return true;
		}
		
		// 4-2. 타입 체크
		if (!(obj instanceof Board)) {
			return false;
		}
		
		// 4-3. 글번호 비교하기위해 다운캐스팅
		Board other = (Board) obj;
		if (this.no.equals(other.no)) {
			return true;
		}
		
		return false;
	}

	// 5. toString 구현
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", writer=");
		builder.append(writer);
		builder.append(", regdate=");
		builder.append(regdate);
		builder.append("]");
		return builder.toString();
	}
}
