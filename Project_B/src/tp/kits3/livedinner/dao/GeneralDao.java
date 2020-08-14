package tp.kits3.livedinner.dao;

import tp.kits3.livedinner.vo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import tp.kits3.livedinner.vo.Category;
import tp.kits3.livedinner.vo.Contact;
import tp.kits3.livedinner.vo.Menu;
import tp.kits3.livedinner.vo.Post;
import tp.kits3.livedinner.vo.Tag;

public class GeneralDao {
	DataSource dataSource;
	public GeneralDao() {
		try {
			Context ctx = new InitialContext();
			Context envCtx =(Context)ctx.lookup("java:/comp/env");
			//get info of Tomcat
			this.dataSource= (DataSource) envCtx.lookup("jdbc/mariadb");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 *------------------ // findAll ALL PASE---------------* */
				public List<Book> findAllBook(){
				List<Book> list =new ArrayList<Book>();
				//list is not null
				try {
					Connection conn = this.dataSource.getConnection();
					String selectAll ="select * from book";
					PreparedStatement pstmt= conn.prepareStatement(selectAll);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						Book book = new Book();
						book.setBkid(rs.getInt("Bkid"));
						book.setBkname(rs.getNString("bkname"));
						book.setBkemail(rs.getNString("bkemail"));
						book.setBkphone(rs.getNString("bkphone"));
						book.setBktime(rs.getTimestamp("bknum"));
						list.add(book);
					
						
					}try {
						rs.close();
						pstmt.close();
						conn.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				return list;
			}	
		public List<Category> findAllCategory(){
				List<Category> list =new ArrayList<Category>();
				//list is not null
				try {
					Connection conn = this.dataSource.getConnection();
					String selectAll ="select * from cateory";
					PreparedStatement pstmt= conn.prepareStatement(selectAll);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						Category category = new Category();
						category.setCtgid(rs.getInt("ctgid"));
						category.setCtname(rs.getString("ctname"));
						category.setService(rs.getString("service"));
						list.add(category);
						
					}try {
						rs.close();
						pstmt.close();
						conn.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				return list;
			}
		public List<Contact> findAllContact(){
				List<Contact> list = new ArrayList<Contact>();
				try {
					Connection conn =this.dataSource.getConnection();
					String selectAll ="select * from contact";
					PreparedStatement pstmt = conn.prepareStatement(selectAll);
					ResultSet rs =pstmt.executeQuery();
					while(rs.next()) {
						Contact contact = new Contact();
						contact.setCoid(rs.getInt("coid"));
						contact.setConame(rs.getNString("coname"));
						contact.setPriphone(rs.getNString("priphone"));
						contact.setSubphone(rs.getNString("email"));
						contact.setUnused(rs.getShort("unused"));
						contact.setOpening(rs.getNString("opening"));
						contact.setWeekday(rs.getNString("weekday"));
						contact.setWeekend(rs.getNString("weekend"));
						contact.setAboutus(rs.getNString("aboutus"));
						contact.setLatitude(rs.getDouble("latitude"));
						contact.setLogitude(rs.getDouble("logitude"));
						list.add(contact);
						
					}try {
						rs.close();
						pstmt.close();
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				return list;
				
			}
		public List<Menu> findAllMenu(){
				List<Menu> list = new ArrayList<Menu>();
				try {
					Connection conn =this.dataSource.getConnection();
					String selectAll ="select * from menu";
					PreparedStatement pstmt = conn.prepareStatement(selectAll);
					ResultSet rs =pstmt.executeQuery();
					while(rs.next()) {
						Menu menu = new Menu();
						menu.setMuid(rs.getInt("muid"));
						menu.setCtgid(rs.getInt("ctgid"));
						menu.setMuname(rs.getNString("muname"));
						menu.setIntro(rs.getNString("intro"));
						menu.setDetails(rs.getNString("details"));
						menu.setPrice(rs.getDouble(""));
						menu.setCurrency(rs.getNString("currency"));
						
						list.add(menu);
						
					}try {
						rs.close();
						pstmt.close();
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				return list;
				
			}
		public List<Post> findAllPost(){
				List<Post> list = new ArrayList<Post>();
				try {
					Connection conn =this.dataSource.getConnection();
					String selectAll ="select * from post";
					PreparedStatement pstmt = conn.prepareStatement(selectAll);
					ResultSet rs =pstmt.executeQuery();
					while(rs.next()) {
						Post post = new Post();
						post.setPid(rs.getInt("pid"));
						post.setTitle(rs.getString("title"));
						post.setByname(rs.getString("byname"));
						post.setRegdate(rs.getTimestamp("regdate"));
						post.setContent(rs.getString("content"));
						post.setVisible(rs.getBoolean("visible"));
						post.setTagid(rs.getInt("tagid"));
						
						list.add(post);
						
					}try {
						rs.close();
						pstmt.close();
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
					return list;
				}
		public List<Tag> findAllTag(){
				List<Tag> list = new ArrayList<Tag>();
				try {
					Connection conn =this.dataSource.getConnection();
					String selectAll ="select * from tag";
					PreparedStatement pstmt = conn.prepareStatement(selectAll);
					ResultSet rs =pstmt.executeQuery();
					while(rs.next()) {
						Tag tag = new Tag();
						tag.setTagid(rs.getInt("tagid"));
						tag.setTgname(rs.getString("tgname"));
						list.add(tag);
						
					}try {
						rs.close();
						pstmt.close();
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
					return list;
				}
		/* *------------------ //End findAll ALL PASE---------------* */	
	/*--------------- save allpage--------------- */
		public void save(Category cateory) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = dataSource.getConnection();
				String insert = "insert into cateory (ctgid,ctname,service)" + "value(?,?,?)";
				pstmt = conn.prepareStatement(insert);
				pstmt.setInt(1, cateory.getCtgid());
				pstmt.setString(2, cateory.getCtname());
				pstmt.setString(3, cateory.getService());
				pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		public void save(Book book) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = dataSource.getConnection();
				String insert="insert into Book (bkid,bkname,bkemail,bkphone,bktime,bknum,booking,bkmemo)"+"value(?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(insert);
				pstmt.setInt(1,book.getBkid());
				pstmt.setString(2,book.getBkname());
				pstmt.setString(3, book.getBkemail());
				pstmt.setString(4, book.getBkphone());
				pstmt.setTimestamp(5, book.getBktime());
				pstmt.setInt(6, book.getBknum());
				pstmt.setString(7, book.getBooking());
				pstmt.setString(8, book.getBkmemo());
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		public void save(Contact contact) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = dataSource.getConnection();
				String insert="insert into Contact (coid,coname,priphone,subphone,email,address,unused,opening,weekday,weekend,aboutus,latitude,logitude)"+"value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(insert);
				pstmt.setInt(1,contact.getCoid());
				pstmt.setString(2,contact.getConame());
				pstmt.setString(3, contact.getPriphone());
				pstmt.setString(4, contact.getSubphone());
				pstmt.setString(5, contact.getEmail());
				pstmt.setString(6, contact.getAddress());
				pstmt.setShort(7, contact.getUnused());
				pstmt.setString(8, contact.getOpening());
				pstmt.setString(9, contact.getWeekday());
				pstmt.setString(10, contact.getWeekend());
				pstmt.setString(11, contact.getAboutus());
				pstmt.setDouble(12, contact.getLogitude());
				pstmt.setDouble(13, contact.getLatitude());
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		public void save(Menu menu) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = dataSource.getConnection();
				String insert ="insert into Menu(muid,ctgid,muname,intro,details,price,currency)"+"value(?,?,?,?,?,?,?)";
				pstmt.setInt(1, menu.getMuid());
				pstmt.setInt(2, menu.getCtgid());
				pstmt.setString(3, menu.getMuname());
				pstmt.setString(4, menu.getIntro());
				pstmt.setString(5, menu.getDetails());
				pstmt.setDouble(6, menu.getPrice());
				pstmt.setString(7,menu.getCurrency());
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		public void save(Post post) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = dataSource.getConnection();
				String insert ="insert into Post(pid,title,byname,rgdate,content,visible,tagid)"+"value(?,?,?,?,?,?,?)";
				pstmt.setInt(1, post.getPid());
				pstmt.setString(2, post.getTitle());
				pstmt.setString(3, post.getByname());
				pstmt.setTimestamp(4, post.getRegdate());
				pstmt.setString(5, post.getContent());
				pstmt.setBoolean(6, post.getVisible());
				pstmt.setInt(7,post.getTagid());
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		public void save(Tag tag) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = dataSource.getConnection();
				String insert ="insert into Post(pid,title,byname,rgdate,content,visible,tagid)"+"value(?,?,?,?,?,?,?)";
				pstmt.setInt(1, tag.getTagid());
				pstmt.setString(2, tag.getTgname());
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		/*--------------- /END save allpage--------------- */
		/*--------------- UPDATE allpage--------------- */
		
		public void update(Category cateory) {
			// update need where ctgid statment
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				conn = dataSource.getConnection();
				String update = "update cateory set ctname=?, service=? where ctgid = ?";
				pstmt = conn.prepareStatement(update);
				pstmt.setString(1, cateory.getCtname());
				pstmt.setString(2, cateory.getService());
				pstmt.setInt(3, cateory.getCtgid());
//				rs = pstmt.executeQuery();
				pstmt.executeUpdate();	
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();				
				}catch(Exception e) {
					
				}
			}
		}
			public void update(Book book) {
				// update need where ctgid statment
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try{
					conn = dataSource.getConnection();
					String update = "update book set bkname=?,bkemail=?,bkphone=?,bktime=?,bknum=?,bkbooking=?,bkmemo=? where ctgid = ?";
					pstmt = conn.prepareStatement(update);
					pstmt.setString(1, book.getBkname());
					pstmt.setString(2, book.getBkemail());
					pstmt.setString(3, book.getBkphone());
					pstmt.setTimestamp(4, book.getBktime());
					pstmt.setInt(5, book.getBknum());
					pstmt.setString(6, book.getBooking());
					pstmt.setString(7, book.getBkmemo());
//					rs = pstmt.executeQuery();
					pstmt.executeUpdate();	
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						rs.close();
						pstmt.close();
						conn.close();				
					}catch(Exception e) {
						
					}
				}
			}
				public void update(Menu menu) {
					// update need where ctgid statment
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					try{
						conn = dataSource.getConnection();
						String update = "update menu set ctgid=?,muname=?,intro=?,details=?,price=?,currency=? where ctgid = ?";
						pstmt = conn.prepareStatement(update);
						pstmt.setInt(1, menu.getMuid());
						pstmt.setInt(2, menu.getCtgid());
						pstmt.setString(3, menu.getMuname());
						pstmt.setString(4, menu.getIntro());
						pstmt.setString(5, menu.getDetails());
						pstmt.setDouble(6, menu.getPrice());
						pstmt.setString(7,menu.getCurrency());
//						rs = pstmt.executeQuery();
						pstmt.executeUpdate();	
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							rs.close();
							pstmt.close();
							conn.close();				
						}catch(Exception e) {
							
						}
					}
			
		}
				public void update(Contact contact) {
					// update need where ctgid statment
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					try{
						conn = dataSource.getConnection();
						String update = "update contact set coname=?,priphone=?,subphone=?,email=?,address=?,unused=?,opening=?, weekday=?,weekend=?,aboutus=?,latitude=?,logitude=? where ctgid = ?";
						pstmt = conn.prepareStatement(update);
						pstmt.setInt(1,contact.getCoid());
						pstmt.setString(2,contact.getConame());
						pstmt.setString(3, contact.getPriphone());
						pstmt.setString(4, contact.getSubphone());
						pstmt.setString(5, contact.getEmail());
						pstmt.setString(6, contact.getAddress());
						pstmt.setShort(7, contact.getUnused());
						pstmt.setString(8, contact.getOpening());
						pstmt.setString(9, contact.getWeekday());
						pstmt.setString(10, contact.getWeekend());
						pstmt.setString(11, contact.getAboutus());
						pstmt.setDouble(12, contact.getLogitude());
						pstmt.setDouble(13, contact.getLatitude());
//						rs = pstmt.executeQuery();
						pstmt.executeUpdate();	
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							rs.close();
							pstmt.close();
							conn.close();				
						}catch(Exception e) {
							
						}
					}
		/*/--------------- END UPDATE all page--------------- */

				}
				public void update(Post post) {
					// update need where ctgid statment
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					try{
						conn = dataSource.getConnection();
						String update = "update post set title=?,byname=?,regdate=?,content=?,visible=?,tagid=? where pid= ?";
						pstmt = conn.prepareStatement(update);
						pstmt.setInt(1, post.getPid());
						pstmt.setString(2, post.getTitle());
						pstmt.setString(3, post.getByname());
						pstmt.setTimestamp(4, post.getRegdate());
						pstmt.setString(5, post.getContent());
						pstmt.setBoolean(6, post.getVisible());
						pstmt.setInt(7,post.getTagid());
//						rs = pstmt.executeQuery();
						pstmt.executeUpdate();	
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							rs.close();
							pstmt.close();
							conn.close();				
						}catch(Exception e) {
							
						}
					}
			
		}
				public void update(Tag tag) {
					// update need where ctgid statment
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					try{
						conn = dataSource.getConnection();
						String update = "update tag set tgname=? where tagid= ?";
						pstmt = conn.prepareStatement(update);
						pstmt.setInt(1, tag.getTagid());
						pstmt.setString(2, tag.getTgname());
//						rs = pstmt.executeQuery();
						pstmt.executeUpdate();	
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							rs.close();
							pstmt.close();
							conn.close();				
						}catch(Exception e) {
							
						}
					}
			
		}
			}



