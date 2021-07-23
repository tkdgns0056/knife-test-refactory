import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import kr.kassadin.knife.util.ScannerUtil;
import kr.kassadin.knife.vo.MovieInfoDTO;
import kr.kassadin.knife.vo.ReservationDTO;
import kr.kassadin.knife.vo.UserDTO;

public class MovieTheater {

	// user �� �α��� ����
	private UserDTO userDto;
	private UserDTO loginUser = null;
	private Scanner scanner;
	private ArrayList<UserDTO> userList;
	private int userNum;
	private int adminNum;

	// ��ȭ ����
	private MovieInfoDTO movieDto;
	private ArrayList<MovieInfoDTO> movieList;
	private int movieIdx;
	
	//���� ����
	private ReservationDTO reservationResult = null;
	private ArrayList<ReservationDTO> resList;
	private int reservationId; //�ε���
	private String [][] arr = new String[5][4];

	// ������
	public MovieTheater() {
		// ���� ���� ���̰���
		userList = new ArrayList<>();
		userDto = new UserDTO();
		scanner = new Scanner(System.in);
		loginUser = new UserDTO();
		userNum = 1;
		adminNum = 0;

		UserDTO u1 = new UserDTO();
		u1.setGrade(1);
		u1.setUserNum(userNum++); // �ε��� �߰�
		u1.setUserId("user001");
		u1.setUserPassword("user001");
		u1.setUserName("¥����");
		u1.setUserAddress("����� ������ ��ġ��");
		u1.setUserPhonenumber("010-1234-1234");

		userList.add(u1);

		UserDTO u2 = new UserDTO();
		u2.setGrade(0);
		u2.setUserNum(adminNum++);
		u2.setUserId("admin001");
		u2.setUserName("admin001");
		u2.setUserPassword("admin001");
		u2.setUserAddress("admin001");
		u2.setUserPhonenumber("admin001");

		userList.add(u2);

		
		
		movieDto = new MovieInfoDTO();
		movieList = new ArrayList<>();
		movieIdx = 1;
		
		// �̸� �� �־��ֱ�
		MovieInfoDTO m1 = new MovieInfoDTO();
		m1.setMovieId(movieIdx++);
		m1.setMovieName("����");
		m1.setDirecter("����ȣ");
		m1.setRunningTime("102��");
		m1.setMovieSummary("��� ��, �Ѱ��� ������ ������ ��Ÿ�� ���� ��ư���." + "\n ���� ��ī�� ���ϱ� ���� �������� ���� ������");
		movieList.add(m1);

		MovieInfoDTO m2 = new MovieInfoDTO();
		m2.setMovieId(movieIdx++);
		m2.setMovieName("���׶�");
		m2.setDirecter("���¿�");
		m2.setRunningTime("115��");
		m2.setMovieSummary("�� �� ���� ���� ������ ���� ���� �ൿ�� ������ö��(Ȳ����),20�� ����� �ºλ� �������塯(���޼�), ���� ���� ȫ���� ���̽�����(������)\n, "
				+ "��ü�� �������硯(����ȯ), ���� �������硯(�����)���� �� ����, �� ��� �� ����, ���ִ� �� ���� Ư�� ���»�� ��� ���������.\n"
				+ "�������� �Ѵ� ���� ���˸� �ذ��� �� ���� �������� ����, ����ö�� ��� 3�� �����¿���(������)�� ������ �ȴ�.\n "
				+ "���� ������ �� ���� ���Ϲ����� ���¿��� ������ ���� ���� ��Ű�� ������ ���ֻ󹫡�(������).\n "
				+ "����ö�� �ǹ��� ����� �Ѵ� �� �׵��� ����� ���Ŀ� ������ �����Ѵ�.\n "
				+ "�ǵ�� ��ģ�ٴ� ����� �ұ��ϰ� �������� �ʴ� ����ö�� ���信���� ������ �� ���� Ŀ������\n "
				+ "���¿��� �̸� ������ �ϵ� ������ �������� ���� �����µ��� \n���׶� ��������� VS ���Ƶ��� ��� 3��2015�� ����, \n" + "�������� �� ���� ����� ���۵ȴ�!");
		movieList.add(m2);

		MovieInfoDTO m3 = new MovieInfoDTO();
		m3.setMovieId(movieIdx++);
		m3.setMovieName("������");
		m3.setDirecter("������");
		m3.setRunningTime("103��");
		m3.setMovieSummary("1979�� ȯ�� 42���� ���� �ڻ�� �������� ���� ����,\n"
				+ "������ �������� �ѷ����� ������ ���ź������ΰ���ü���� ���� 7���� ���������, ���� ġ���, �����, ������ �ʴ� 402ȣ��\n"
				+ "������ ��ü�� ��Ƴ��� ���غ��� ���θ� �Կ��ϱ� �����ϴ� ����鿡�Ի�� ���� �����ϰ� ���������� �ϵ��̽����� �������� ���� �ϴµ���\n"
				+ "���� ����� ������ �ݵ�� ������ �ִ�.�Ҹ� ��ġ�� �������� ���ź����� �� ��ü�� ü���϶�!");
		movieList.add(m3);

		MovieInfoDTO m4 = new MovieInfoDTO();
		m4.setMovieId(movieIdx++);
		m4.setMovieName("������");
		m4.setDirecter("������");
		m4.setRunningTime("103��");
		m4.setMovieSummary("������ ������� �Ƴ��� �Ұ� ������ ���� ä �������� ��ϸ� �ܷӰ� ��ư��� ���� Ư����� �½�. \n"
				+ "�½��� �ҹ̸� ���ϱ� ���� ���������� �ŷ��� �ϰ� �ǰ�, �̷� ���� �������� �½��� �߰��ϰ� �ȴ�.\n"
				+ " �� ������ �� ������ ���������� �߽ɿ� �ٰ����鼭 ���Ͽ� �ο��ִ� �½��� ��н��� ���ŵ� �Բ� �巯���� �Ǵµ��� ");
		movieList.add(m4);
		
		//���� ����
		reservationResult = new ReservationDTO();
		resList = new ArrayList<>();
		reservationId = 1;
		arr = new String[5][4];
		for(String[] row: arr) {
			Arrays.fill(row, "O");
		}
	}

	public void init() {

		System.out.println(" ___________________________");
		System.out.println("|                           |");
		System.out.println("|       ��ȭ���� ���α׷�        |");
		System.out.println("|___________________________|");
		System.out.println();

		while (true) {
			UserDTO u = new UserDTO();
			String message;
			message = new String(" 1.ȸ������\n  2.�α���\n  3.����");
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

			if (userChoice == 1) {
				System.out.println();
				System.out.println("�Ʒ��� �°� ������ ���ּ���");
				System.out.println();

				message = new String("Id: ");
				u.setUserId(ScannerUtil.nextLine(scanner, message));
				while (validateUsername(u)) {
					System.out.println("�̹� ��ϵ� ���̵� �Դϴ�.");
					message = new String("ID: ");
					u.setUserId(ScannerUtil.nextLine(scanner, message));
				}

				message = new String("��й�ȣ: ");
				u.setUserPassword(ScannerUtil.nextLine(scanner, message));

				message = new String("����: ");
				u.setUserName(ScannerUtil.nextLine(scanner, message));

				message = new String("�ּ�: ");
				u.setUserAddress(ScannerUtil.nextLine(scanner, message));

				message = new String("�޴�����ȣ: ");
				u.setUserPhonenumber(ScannerUtil.nextLine(scanner, message));

				System.out.println("ȸ�������� ���ϵ帳�ϴ�!");
				u.setGrade(1);
				userList.add(u);

			} else if (userChoice == 2) {
				System.out.println();
				System.out.println("________________________");
				System.out.println();

				message = new String(" 1. ID/PW �Է�\n 2. ��������");
				userChoice = ScannerUtil.nextInt(scanner, message);
				
				// �α��� ID/PW �Է�
				if (userChoice == 1) {
					message = new String("ID: ");
					userDto.setUserId(ScannerUtil.nextLine(scanner, message));

					message = new String("��й�ȣ: ");
					userDto.setUserPassword(ScannerUtil.nextLine(scanner, message));

					loginUser = auth(userDto);

					while (loginUser == null) {
						System.out.println("��ġ���� ���� �α��� �����Դϴ�.");
						message = new String("�ٽ� �Է��Ͻðھ��? y/n");

						String agree = ScannerUtil.nextLine(scanner, message);
						if (agree.equalsIgnoreCase("n")) {
							break;
						} else {

							message = new String("ID: ");
							userDto.setUserId(ScannerUtil.nextLine(scanner, message));

							message = new String("��й�ȣ: ");
							userDto.setUserPassword(ScannerUtil.nextLine(scanner, message));

							loginUser = auth(userDto);

						}
					}
					//��������
				} else if (userChoice == 2) {
					System.out.println();
					System.out.println("________________________");
					System.out.println();
					System.out.println("�޴��� ���ư���");
					System.out.println();
					break;

				}
				int gradeType = loginUser.getGrade();
				if (gradeType == 1) {
					
					System.out.println("�α��� �� ���� ��ȣ : " + loginUser.getUserId());
					
					System.out.println();
					System.out.println("________________________");
					System.out.println("       ���� ������          ");
					System.out.println();
					
					while(true) {
						message = new String(" 1.��ȭ ����Ʈ\n 2.�¼� ����\n 3.�����ϱ�\n 4.���ų�������\n 5.�������\n 6.��������");
						userChoice = ScannerUtil.nextInt(scanner, message, 1, 6);
						if(userChoice == 1) {
							list();
							select();
						}else if (userChoice == 2){
							list();
							System.out.println("________________________");
							message = new String("�¼� ���� ��ȭ��ȣ�� �����ϼ���");
							movieIdx = ScannerUtil.nextInt(scanner, message);
							
							movieDto = movieSelectOne(movieIdx);
							
							for(String[] row : arr) {
								System.out.println(Arrays.toString(row));
							}
							System.out.println("________________________");
							
						}else if(userChoice == 3) {
							list();
							System.out.println("________________________");
							while(true) {
								message = new String("1. �����ϱ�\n2. ��������\n");
								userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);
								if (userChoice == 1) {
									message = new String("�����Ͻ� ��ȭ��ȣ�� �Է��ϼ���");
									movieIdx = ScannerUtil.nextInt(scanner, message);
									
									movieDto = movieSelectOne(movieIdx);
									
									ReservationDTO r = new ReservationDTO();
					
									for(String[] row : arr) {
										System.out.println(Arrays.toString(row));
									}

									System.out.println();
							        System.out.println("________________________");
							        System.out.println();
							    
							        r.setMovieId(movieDto.getMovieId());
							        r.setUserNum(loginUser.getUserNum());
							        
									message = new String("1.�����Ͻ� ���� �Է��ϼ���(1~5) , 2.���(x)");
									r.setRow(ScannerUtil.nextInt(scanner, message, 1, 5));

									message = new String("1.�����Ͻ� ���� �Է��ϼ��� (1~4) , 2.���(x)");
									r.setColumn(ScannerUtil.nextInt(scanner, message, 1, 4));
									
									if(arr[r.getRow()-1][r.getColumn()-1].equals("X")){
										System.out.println("�̹� ����� �ڸ��Դϴ�.");
									}else {
										arr[r.getRow()-1][r.getColumn()-1] = "X";
										
										reservationResult = r;
										System.out.println(r.getRow()+"��" + r.getColumn() +"�� �ڸ��� ����Ǿ����ϴ�.");
										reservationAdd(r); //����Ǿ��� �� ���� ��ȣ �߰�
										System.out.println("���� ���� ��ȣ :" + r.getReservationId() +"��");
										System.out.println("������ ��ȭ ��ȣ: " +  r.getMovieIdx() + "��");
										System.out.println("�� ���� ��ȣ:" + r.getUserNum() + "��");
	
									}
																		
								} else if (userChoice == 2) {
									System.out.println();
									System.out.println("________________________");
									System.out.println();
									System.out.println(" �������� ");
									System.out.println();
									break;
								}
							}
							
						}else if(userChoice == 4) {
							System.out.println("________________________");
							System.out.println("���� ���� ����");
							System.out.println();
							System.out.println("���� ���� ���� ��ȣ : " + loginUser.getUserNum());
								
								if(loginUser.getUserNum() == reservationResult.getUserNum() && resList.contains(reservationResult)) {
								  for(ReservationDTO r : resList) {
									System.out.println("�� ���� ��ȣ: " + r.getReservationId());	
								  	}
								}
								  System.out.println("________________________");
						
						}else if(userChoice == 5) {
							
							System.out.println("________________________");
							System.out.println("���� ��� â");
							System.out.println();
							
							for(ReservationDTO r : resList) {
								if(loginUser.getUserNum() == reservationResult.getUserNum()) {
								System.out.println("�� ���� ��ȣ: " + r.getReservationId()+"\n");
							}
						}
							 message = new String("��� �Ͻ� ���� ��ȣ�� �Է��ϼ���.");
							 reservationId = ScannerUtil.nextInt(scanner, message);

							 reservationResult = resverationSelectOne(reservationId);
								
								message = new String("���Ÿ� �����Ͻðڽ��ϱ�? (y/n)");
								
								String yesNo = ScannerUtil.nextLine(scanner, message);
								if (yesNo.equalsIgnoreCase("y")) {
									System.out.println("���� �Ǿ����ϴ�.");
									reservationDelete(reservationResult);
								}
							 
							System.out.println("________________________");
						}
					}

				} else if (gradeType == 0) {
					System.out.println();
					System.out.println("________________________");
					System.out.println();
					System.out.println("     ������ ������        ");
					System.out.println();

					while (true) {
						message = new String("1. ��ȭ ����Ʈ\n2. �α׾ƿ�");
						userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);
						if (userChoice == 1) {
							System.out.println();
							System.out.println("________________________");
							System.out.println();
							while (true) {
								message = new String("1. ��ȸ\n2. ���\n3. ����\n4. ����\n5. ��������������");
								userChoice = ScannerUtil.nextInt(scanner, message, 1, 5);
								if (userChoice == 1) {
										
										list();
										select();
										
								} else if (userChoice == 2) { //��ȭ ���
									viewMoveRegist();
									
								} else if (userChoice == 3) { //��ȭ ����
					
									viewMovieEdit();
							
								} else if (userChoice == 4) {
									
									viewMovieDelete();
									
								} else if (userChoice == 5) {
									System.out.println();
									System.out.println("________________________");
									System.out.println();
									System.out.println(" ������ ������ ");
									System.out.println();
									break;
								}
								
							} //������ ������ ��ȭ���� while ��
							
						} else if (userChoice == 2) {
								System.out.println();
								System.out.println("____________________");
								System.out.println(" ���� ������ ");
								System.out.println();
								break;
								
							}
						  } // while�� ��
					
						} else if (userChoice == 3) {
							System.out.println();
							System.out.println("*****************************************************");
							System.out.println("*                                                   *");
							System.out.println("* ����Ǿ����ϴ�. *");
							System.out.println("*                                                   *");
							System.out.println("*****************************************************");
							System.out.println();
							break;
						}
				
				}
			}
		}

	private void viewMovieDelete() {
		String message;
		System.out.println();
		System.out.println("________________________");
		System.out.println();
		System.out.println("��ȭ ����");
		System.out.println();
		list();
		

		message = new String("������ ��ȭ ��ȣ�� �Է��ϼ���.");
		movieIdx = ScannerUtil.nextInt(scanner, message);
		
		movieDto = movieSelectOne(movieIdx);
		
		message = new String("������ ��ȭ�� �����Ͻðڽ��ϱ�? (y/n)");
		
		String yesNo = ScannerUtil.nextLine(scanner, message);
		if (yesNo.equalsIgnoreCase("y")) {
			System.out.println("���� �Ǿ����ϴ�.");
			movieDelete(movieDto);
		}
	}

	private void viewMoveRegist() {
		String message;
		MovieInfoDTO m = new MovieInfoDTO();
		System.out.println();
		System.out.println("________________________");
		System.out.println();
		System.out.println("��ȭ ���");
		System.out.println();

		message = new String("����: ");
		m.setMovieName(ScannerUtil.nextLine(scanner, message));

		message = new String("�󿵽ð�: ");
		m.setRunningTime(ScannerUtil.nextLine(scanner, message));

		message = new String("����: ");
		m.setDirecter(ScannerUtil.nextLine(scanner, message));

		message = new String("�帣: ");
		m.setMovieGenre(ScannerUtil.nextLine(scanner, message));

		message = new String("�ٰŸ�: ");
		m.setMovieSummary(ScannerUtil.nextLine(scanner, message));

		message = new String("����: ");
		m.setMoviePrice(ScannerUtil.nextInt(scanner, message));

		addMovie(m);
	}

	private void viewMovieEdit() {
		String message;
		System.out.println();
		System.out.println("________________________");
		System.out.println();
		System.out.println("��ȭ ����");
		System.out.println();

		list();

		message = new String("�����Ͻ� ��ȭ ��ȣ�� �Է��ϼ���");
		movieIdx = ScannerUtil.nextInt(scanner, message);
		
		movieDto = movieSelectOne(movieIdx);
		
		message = new String("����: ");
		movieDto.setMovieName(ScannerUtil.nextLine(scanner, message));

		message = new String("�󿵽ð�: ");
		movieDto.setRunningTime(ScannerUtil.nextLine(scanner, message));

		message = new String("����: ");
		movieDto.setDirecter(ScannerUtil.nextLine(scanner, message));

		message = new String("�帣: ");
		movieDto.setMovieGenre(ScannerUtil.nextLine(scanner, message));

		message = new String("�ٰŸ�: ");
		movieDto.setMovieSummary(ScannerUtil.nextLine(scanner, message));

		message = new String("����: ");
		movieDto.setMoviePrice(ScannerUtil.nextInt(scanner, message));

		movieUpdate(movieDto);
	}

	// ȸ������ �� �ߺ��� �� ��ȿ�� �˻� �ϱ�
	public boolean validateUsername(UserDTO user) {
		for (UserDTO u : userList) {
			if (u.getUserId().equals(user.getUserId())) {
				return true;
			}
		}
		return false;
	}

	// �α��ν� userList�� �߰��ϱ�, ���� idx +1 �ϱ�.
	public void add(UserDTO u) {
		u.setUserNum(userNum++);
		u.setGrade(1);

		userList.add(u);
	}

	public UserDTO selectOne(int userNum) {
		for (UserDTO u : userList) {
			if (u.getUserNum() == userNum) {
				return u;
			}
		}

		return null;
	}

	// �α��� ��ȿ�� �˻�
	public UserDTO auth(UserDTO user) {
		for (UserDTO u : userList) {
			if (u.getUserId().equals(user.getUserId()) && u.getUserPassword().equals(u.getUserPassword())) {
				return u;
			}
		}
		return null;
	}

	// ��ȭ ��ü ����Ʈ ���
	public ArrayList<MovieInfoDTO> printAll() {
		for (MovieInfoDTO m : movieList) {

		}
		return movieList;
	}

	// ��ȭ �ϳ� ����
	public MovieInfoDTO movieSelectOne(int movieId) {
		for (MovieInfoDTO m : movieList) {
			if (m.getMovieId() == movieId) {
				return m;
			}
		}
		return null;
	}

	// ��ȭ ���
	public void addMovie(MovieInfoDTO m) {
		m.setMovieId(movieIdx++);

		movieList.add(m);
	}

	// ��ȭ ����
	public void movieUpdate(MovieInfoDTO updated) {
		for (MovieInfoDTO m : movieList) {
			if (m.getMovieId() == updated.getMovieId()) {
				m.setMovieName(updated.getMovieName());
				m.setDirecter(updated.getDirecter());
				m.setRunningTime(updated.getRunningTime());
				m.setMovieSummary(updated.getMovieSummary());
			}
		}
	}

	// ��ȭ ����
	public void movieDelete(MovieInfoDTO m) {
		movieList.remove(m);
	}

	//���� �߰�
	public void reservationAdd(ReservationDTO r) {
		r.setReservationId(reservationId++);
		resList.add(r);
	}
	
	//���� ����
	public void reservationDelete(ReservationDTO r) {
		resList.remove(r);
		
	}
	
	// ���� �ϳ� ����
	public ReservationDTO  resverationSelectOne(int resverationId) {
		for (ReservationDTO r : resList) {
			if (r.getReservationId() == resverationId) {
				return r;
			}
		}
		return null;
	}
	
	
	// ��ȭ ����Ʈ(�̰� ����, ������ �� �ʿ��ؼ� �޼ҵ�� ���� �M)
	public void list() {

		movieList = printAll();

		if (movieList.isEmpty()) {
			System.out.println();
			System.out.println("________________________");
			System.out.println();
			System.out.println("��ϵ� ��ȭ�� �����ϴ�. ��ȭ�� ������ּ���");
			System.out.println();
			System.out.println("________________________");
			System.out.println();
		}
		System.out.println();
		System.out.println("________________________");
		System.out.println();
		for (MovieInfoDTO m : movieList) {
			System.out.printf("Id: %d  ��ȭ����: %s\n", m.getMovieId(), m.getMovieName());
		}
	}

	public void select() {
		System.out.println();
		System.out.println("________________________");
		System.out.println();
		String message;
		while (true) {
			message = new String("1. ��ȣ����ȸ\n2. �˻�������ȸ\n3. ��������");
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
			if (userChoice == 1) {
				numberMovieList();
			} else if (userChoice == 2) {
				searchMovieList(message);
			} else if (userChoice == 3) {
				System.out.println();
				System.out.println("________________________");
				System.out.println();
				System.out.println(" �������� ");
				System.out.println();
				break;
			}

		}
	}
	
	//��ȣ�� ��ȸ
	public void numberMovieList() {
		String message;
		message = new String("��ȭ ��ȣ�� �����ϼ���");
		movieIdx = ScannerUtil.nextInt(scanner, message);

		movieDto = movieSelectOne(movieIdx);

		System.out.println();
		System.out.println("________________________");
		System.out.println();
		System.out.println("     ������ ��ȭ    ");
		System.out.println();
		System.out.printf("����: %s\n�󿵽ð�: %s\n����: %s\n�帣: %s\n�ٰŸ�: %s\n����: %d\n", movieDto.getMovieName(), movieDto.getRunningTime(),
				movieDto.getDirecter(), movieDto.getMovieGenre(), movieDto.getMovieSummary(), movieDto.getMoviePrice());
		System.out.println();
		System.out.println("________________________");
		System.out.println();
	}
	
	public void searchMovieList(String search) {
		String message;
		while (true) {
			message = new String("1. �������ΰ˻�\n2. ������������ȸ\n3. �帣�ΰ˻�\n4.��������");
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);
			if (userChoice == 1) {
				message = new String("�����Է�:");
				search = ScannerUtil.nextLine(scanner, message);
				MovieInfoDTO titleSearch = null;

				for (MovieInfoDTO m : movieList) {
					if (m.getMovieName().equals(search)) {
						titleSearch = m;
						System.out.println("------------- �˻� ��� ------------------");
						System.out.printf("Id: %d  ��ȭ����: %s\n", titleSearch.getMovieId(), titleSearch.getMovieName());
						System.out.println("----------------------------------------");
					}

					if (!m.getMovieName().equals(search)) {
						System.out.println("��ġ�ϴ� ����� �����ϴ�.");
					}

				}

			} else if (userChoice == 2) {
				message = new String("�������Է�:");
				search = ScannerUtil.nextLine(scanner, message);
				MovieInfoDTO titleSearch = null;

				for (MovieInfoDTO m : movieList) {
					if (m.getDirecter().equals(search)) {
						titleSearch = m;
						System.out.println("------------- �˻� ��� ------------------");
						System.out.printf("Id: %d  ��ȭ����: %s\n", titleSearch.getMovieId(), titleSearch.getMovieName());
						System.out.println("----------------------------------------");
					}

					if (!m.getDirecter().equals(search)) {
						System.out.println("��ġ�ϴ� ����� �����ϴ�.");
					}

				}
			} else if (userChoice == 3) {
				message = new String("�帣�Է�:");
				search = ScannerUtil.nextLine(scanner, message);
				MovieInfoDTO titleSearch = null;

				for (MovieInfoDTO m : movieList) {
					if (m.getMovieGenre().equals(search)) {
						titleSearch = m;
						System.out.println("------------- �˻� ��� ------------------");
						System.out.printf("Id: %d  ��ȭ����: %s\n", titleSearch.getMovieId(), titleSearch.getMovieName());
						System.out.println("----------------------------------------");
					}

					if (!m.getMovieGenre().equals(search)) {
						System.out.println("��ġ�ϴ� ����� �����ϴ�.");
					}

				}
			} else if (userChoice == 4) {
				System.out.println();
				System.out.println("________________________");
				System.out.println();
				System.out.println(" �������� ");
				System.out.println();
				break;

			}
		}
	}
	
}
