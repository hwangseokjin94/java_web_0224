package com.koreait.mvc14.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.koreait.mvc14.common.Constant;
import com.koreait.mvc14.dto.ContactDTO;

public class ContactDAO {

	private JdbcTemplate template;
	public ContactDAO() {
		this.template = Constant.template;
		
	}
	//1.ContactListViewCommand selectContactList()
	public ArrayList<ContactDTO> selectContactList(){
		String sql = "SELECT CNO, CNAME ,CPHONE ,CADDRESS ,CEMAIL ,CNOTE FROM CONTACT";
		ArrayList<ContactDTO> list = (ArrayList<ContactDTO>)template.query(sql, new BeanPropertyRowMapper<ContactDTO>(ContactDTO.class));
		return list;
	}
	//selectContactByNo()
	public ContactDTO selectContactByNo(int cNo){
		String sql ="SELECT CNO, CNAME ,CPHONE ,CADDRESS ,CEMAIL ,CNOTE FROM CONTACT WHERE CNO ="+cNo;
		ContactDTO cDTO = template.queryForObject(sql, new BeanPropertyRowMapper<ContactDTO>(ContactDTO.class));
		return cDTO;
	}
	//3.contactInsert()
	public void contactInsert(final String cName, final String cPhone,final String cAddress, final String cEmail,final String cNote) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "INSERT INTO CONTACT (CNO,CNAME,CPHONE,CADDRESS,CEMAIL,CNOTE) VALUES(CONTACT_SEQ.NEXTVAL,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, cName);
				ps.setString(2, cPhone);
				ps.setString(3, cAddress);
				ps.setString(4, cEmail);
				ps.setString(5, cNote);
				return ps;			
			}
		});
	}
	
	
	
}
