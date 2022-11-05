package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.bean.Livro;

public class LivroDao {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdlivraria", "Eik", "Eik981934478");
		}catch (Exception e){
			System.out.println(e);
		}
		return con;
	}
	
	public static int deletarLivro(Livro l) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("delete from tblivros where codlivro=?");
			ps.setInt(1, l.getCodlivro());
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int salvarLivro(Livro l) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into tblivros (codlivro, titulo, autor, categoria, valor) values (?, ?, ?, ?, ?)");
			ps.setInt(1, l.getCodlivro());
			ps.setString(2, l.getTitulo());
			ps.setString(3, l.getAutor());
			ps.setString(4, l.getCategoria());
			ps.setFloat(5, l.getValor());
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int updateLivro(Livro l) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("update tblivros set titulo=?, autor=?, categoria=?, valor=? where codlivro=?");
			ps.setString(1, l.getTitulo());
			ps.setString(2, l.getAutor());
			ps.setString(3, l.getCategoria());
			ps.setFloat(4, l.getValor());
			ps.setInt(5, l.getCodlivro());
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static Livro getRegisterById(int codlivro) {
		Livro livro = null;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from tblivros where codlivro = ?");
			ps.setInt(1, codlivro);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				livro = new Livro();
				livro.setCodlivro(rs.getInt("codlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setCategoria(rs.getString("categoria"));
				livro.setValor(rs.getFloat("valor"));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return livro;
	}
	
	public static List<Livro> getAllLivros() {
		List<Livro> list = new ArrayList<Livro>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from tblivros");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Livro livro = new Livro();
				livro.setCodlivro(rs.getInt("codlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setCategoria(rs.getString("categoria"));
				livro.setValor(rs.getFloat("valor"));
				list.add(livro);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static List<Livro> getAllbyCategoria(Livro l) {
		List<Livro> list = new ArrayList<Livro>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from tblivros where categoria = ?");
			ps.setString(1, l.getCategoria());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Livro livro = new Livro();
				livro = new Livro();
				livro.setCodlivro(rs.getInt("codlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setCategoria(rs.getString("categoria"));
				livro.setValor(rs.getFloat("valor"));
				list.add(livro);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static List<Livro> getAllbyCodigo(Livro l) {
		List<Livro> list = new ArrayList<Livro>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from tblivros where codlivro = ?");
			ps.setInt(1, l.getCodlivro());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Livro livro = new Livro();
				livro = new Livro();
				livro.setCodlivro(rs.getInt("codlivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setCategoria(rs.getString("categoria"));
				livro.setValor(rs.getFloat("valor"));
				list.add(livro);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
