package com.koitt.board.model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.board.dao.BoardDao;
import com.koitt.board.vo.Board;

public class UpdateFormCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ClassNotFoundException, SQLException, IllegalArgumentException, NullPointerException {
		
		//1. 포워딩할 JSP 주소
		String page= "./board/update-form.jsp";

		//2. 수정할 글의 정보를 불러올 no값을 view.jsp의 수정하기 버튼의 링크를 통해 받아옴 
		String _no= req.getParameter("no");

		//3. no의 값이 없을경우 예외발생 
		if(_no ==null ||_no.trim().length()==0) {
			throw new IllegalArgumentException("게시물 번호가 필요합니다.");
		}

		//4. String 타입의 no값을 Integer로 변경
		Integer no = Integer.parseInt(_no);

		//5.수정할 글의 정보를 불러오기 위해 BoardDao 객체 생성
		BoardDao dao = new BoardDao();
		//6. select메소드를 통해 수정할 글 정보 불러오기
		Board board =dao.select(no);
		
		//7. 불러올 글이 없다면 예외 발생
		if(board == null) {
			throw new NullPointerException("없거나 삭제된 게시물입니다.");

		}
		//8.수정할 글 정보를 JSP페이지로 포워딩
		req.setAttribute("board", board);

		//9.BoardServlet(Controller)로 포워딩할 JSP페이지 주소 전달
		return page;
	}

}
