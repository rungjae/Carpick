package carpick.board.model;

import java.sql.Date;

public class Board {
	private Long seq;
	private String writer;
	private String email;
	private String subject;
	private String content;
	private Date rdate;
	
	public Board() {//다른 패키지에 있는 controller가 접근할 수 있게 
		super();
	}

	public Board(Long seq, String writer, String email, String subject, String content, Date rdate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.rdate = rdate;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
}
