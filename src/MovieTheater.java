import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import kr.kassadin.knife.util.ScannerUtil;
import kr.kassadin.knife.vo.MovieInfoDTO;
import kr.kassadin.knife.vo.ReservationDTO;
import kr.kassadin.knife.vo.UserDTO;

public class MovieTheater {

	// user 및 로그인 관련
	private UserDTO userDto;
	private UserDTO loginUser = null;
	private Scanner scanner;
	private ArrayList<UserDTO> userList;
	private int userNum;
	private int adminNum;

	// 영화 관련
	private MovieInfoDTO movieDto;
	private ArrayList<MovieInfoDTO> movieList;
	private int movieIdx;
	
	//예약 관련
	private ReservationDTO reservationResult = null;
	private ArrayList<ReservationDTO> resList;
	private int reservationId; //인덱스
	private String [][] arr = new String[5][4];

	// 생성자
	public MovieTheater() {
		// 유저 관련 더미값들
		userList = new ArrayList<>();
		userDto = new UserDTO();
		scanner = new Scanner(System.in);
		loginUser = new UserDTO();
		userNum = 1;
		adminNum = 0;

		UserDTO u1 = new UserDTO();
		u1.setGrade(1);
		u1.setUserNum(userNum++); // 인덱스 추가
		u1.setUserId("user001");
		u1.setUserPassword("user001");
		u1.setUserName("짜무니");
		u1.setUserAddress("서울시 강남구 대치동");
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
		
		// 미리 값 넣어주기
		MovieInfoDTO m1 = new MovieInfoDTO();
		m1.setMovieId(movieIdx++);
		m1.setMovieName("괴물");
		m1.setDirecter("봉준호");
		m1.setRunningTime("102분");
		m1.setMovieSummary("어느 날, 한강에 괴상한 괴물이 나타나 딸을 잡아간다." + "\n 딸과 조카를 구하기 위해 가족끼리 모인 사투극");
		movieList.add(m1);

		MovieInfoDTO m2 = new MovieInfoDTO();
		m2.setMovieId(movieIdx++);
		m2.setMovieName("베테랑");
		m2.setDirecter("류승완");
		m2.setRunningTime("115분");
		m2.setMovieSummary("한 번 꽂힌 것은 무조건 끝을 보는 행동파 ‘서도철’(황정민),20년 경력의 승부사 ‘오팀장’(오달수), 위장 전문 홍일점 ‘미스봉’(장윤주)\n, "
				+ "육체파 ‘왕형사’(오대환), 막내 ‘윤형사’(김시후)까지 겁 없고, 못 잡는 것 없고, 봐주는 것 없는 특수 강력사건 담당 광역수사대.\n"
				+ "오랫동안 쫓던 대형 범죄를 해결한 후 숨을 돌리려는 찰나, 서도철은 재벌 3세 ‘조태오’(유아인)를 만나게 된다.\n "
				+ "세상 무서울 것 없는 안하무인의 조태오와 언제나 그의 곁을 지키는 오른팔 ‘최상무’(유해진).\n "
				+ "서도철은 의문의 사건을 쫓던 중 그들이 사건의 배후에 있음을 직감한다.\n "
				+ "건들면 다친다는 충고에도 불구하고 포기하지 않는 서도철의 집념에판은 걷잡을 수 없이 커져가고\n "
				+ "조태오는 이를 비웃기라도 하듯 유유히 포위망을 빠져 나가는데… \n베테랑 광역수사대 VS 유아독존 재벌 3세2015년 여름, \n" + "자존심을 건 한판 대결이 시작된다!");
		movieList.add(m2);

		MovieInfoDTO m3 = new MovieInfoDTO();
		m3.setMovieId(movieIdx++);
		m3.setMovieName("곤지암");
		m3.setDirecter("정범식");
		m3.setRunningTime("103분");
		m3.setMovieSummary("1979년 환자 42명의 집단 자살과 병원장의 실종 이후,\n"
				+ "섬뜩한 괴담으로 둘러싸인 곤지암 정신병원으로공포체험을 떠난 7명의 멤버들원장실, 집단 치료실, 실험실, 열리지 않는 402호…\n"
				+ "괴담의 실체를 담아내기 위해병원 내부를 촬영하기 시작하던 멤버들에게상상도 못한 기이하고 공포스러운 일들이실제로 벌어지기 시작 하는데…\n"
				+ "가지 말라는 곳에는 반드시 이유가 있다.소름 끼치는 ‘곤지암 정신병원’ 의 실체를 체험하라!");
		movieList.add(m3);

		MovieInfoDTO m4 = new MovieInfoDTO();
		m4.setMovieId(movieIdx++);
		m4.setMovieName("아저씨");
		m4.setDirecter("이정범");
		m4.setRunningTime("103분");
		m4.setMovieSummary("불행한 사건으로 아내를 잃고 세상을 등진 채 전당포를 운영하며 외롭게 살아가는 전직 특수요원 태식. \n"
				+ "태식은 소미를 구하기 위해 범죄조직과 거래를 하게 되고, 이로 인해 경찰마저 태식을 추격하게 된다.\n"
				+ " 한 걸음씩 한 걸음씩 범죄조직의 중심에 다가서면서 베일에 싸여있던 태식의 비밀스런 과거도 함께 드러나게 되는데… ");
		movieList.add(m4);
		
		//예약 관련
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
		System.out.println("|       영화예매 프로그램        |");
		System.out.println("|___________________________|");
		System.out.println();

		while (true) {
			UserDTO u = new UserDTO();
			String message;
			message = new String(" 1.회원가입\n  2.로그인\n  3.종료");
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

			if (userChoice == 1) {
				System.out.println();
				System.out.println("아래에 맞게 기입을 해주세요");
				System.out.println();

				message = new String("Id: ");
				u.setUserId(ScannerUtil.nextLine(scanner, message));
				while (validateUsername(u)) {
					System.out.println("이미 등록된 아이디 입니다.");
					message = new String("ID: ");
					u.setUserId(ScannerUtil.nextLine(scanner, message));
				}

				message = new String("비밀번호: ");
				u.setUserPassword(ScannerUtil.nextLine(scanner, message));

				message = new String("성함: ");
				u.setUserName(ScannerUtil.nextLine(scanner, message));

				message = new String("주소: ");
				u.setUserAddress(ScannerUtil.nextLine(scanner, message));

				message = new String("휴대폰번호: ");
				u.setUserPhonenumber(ScannerUtil.nextLine(scanner, message));

				System.out.println("회원가입을 축하드립니다!");
				u.setGrade(1);
				userList.add(u);

			} else if (userChoice == 2) {
				System.out.println();
				System.out.println("________________________");
				System.out.println();

				message = new String(" 1. ID/PW 입력\n 2. 메인으로");
				userChoice = ScannerUtil.nextInt(scanner, message);
				
				// 로그인 ID/PW 입력
				if (userChoice == 1) {
					message = new String("ID: ");
					userDto.setUserId(ScannerUtil.nextLine(scanner, message));

					message = new String("비밀번호: ");
					userDto.setUserPassword(ScannerUtil.nextLine(scanner, message));

					loginUser = auth(userDto);

					while (loginUser == null) {
						System.out.println("일치하지 않은 로그인 정보입니다.");
						message = new String("다시 입력하시겠어요? y/n");

						String agree = ScannerUtil.nextLine(scanner, message);
						if (agree.equalsIgnoreCase("n")) {
							break;
						} else {

							message = new String("ID: ");
							userDto.setUserId(ScannerUtil.nextLine(scanner, message));

							message = new String("비밀번호: ");
							userDto.setUserPassword(ScannerUtil.nextLine(scanner, message));

							loginUser = auth(userDto);

						}
					}
					//메인으로
				} else if (userChoice == 2) {
					System.out.println();
					System.out.println("________________________");
					System.out.println();
					System.out.println("메뉴로 돌아가기");
					System.out.println();
					break;

				}
				int gradeType = loginUser.getGrade();
				if (gradeType == 1) {
					
					System.out.println("로그인 한 유저 번호 : " + loginUser.getUserId());
					
					System.out.println();
					System.out.println("________________________");
					System.out.println("       유저 페이지          ");
					System.out.println();
					
					while(true) {
						message = new String(" 1.영화 리스트\n 2.좌석 보기\n 3.예매하기\n 4.예매내역보기\n 5.예매취소\n 6.이전으로");
						userChoice = ScannerUtil.nextInt(scanner, message, 1, 6);
						if(userChoice == 1) {
							list();
							select();
						}else if (userChoice == 2){
							list();
							System.out.println("________________________");
							message = new String("좌석 보실 영화번호를 선택하세요");
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
								message = new String("1. 예매하기\n2. 이전으로\n");
								userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);
								if (userChoice == 1) {
									message = new String("예매하실 영화번호를 입력하세요");
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
							        
									message = new String("1.예약하실 행을 입력하세요(1~5) , 2.취소(x)");
									r.setRow(ScannerUtil.nextInt(scanner, message, 1, 5));

									message = new String("1.예약하실 열을 입력하세요 (1~4) , 2.취소(x)");
									r.setColumn(ScannerUtil.nextInt(scanner, message, 1, 4));
									
									if(arr[r.getRow()-1][r.getColumn()-1].equals("X")){
										System.out.println("이미 예약된 자리입니다.");
									}else {
										arr[r.getRow()-1][r.getColumn()-1] = "X";
										
										reservationResult = r;
										System.out.println(r.getRow()+"행" + r.getColumn() +"열 자리가 예약되었습니다.");
										reservationAdd(r); //예약되었을 시 예매 번호 추가
										System.out.println("나의 예약 번호 :" + r.getReservationId() +"번");
										System.out.println("예약한 영화 번호: " +  r.getMovieIdx() + "번");
										System.out.println("고객 고유 번호:" + r.getUserNum() + "번");
	
									}
																		
								} else if (userChoice == 2) {
									System.out.println();
									System.out.println("________________________");
									System.out.println();
									System.out.println(" 이전으로 ");
									System.out.println();
									break;
								}
							}
							
						}else if(userChoice == 4) {
							System.out.println("________________________");
							System.out.println("나의 예매 내역");
							System.out.println();
							System.out.println("나의 유저 고유 번호 : " + loginUser.getUserNum());
								
								if(loginUser.getUserNum() == reservationResult.getUserNum() && resList.contains(reservationResult)) {
								  for(ReservationDTO r : resList) {
									System.out.println("내 예약 번호: " + r.getReservationId());	
								  	}
								}
								  System.out.println("________________________");
						
						}else if(userChoice == 5) {
							
							System.out.println("________________________");
							System.out.println("예매 취소 창");
							System.out.println();
							
							for(ReservationDTO r : resList) {
								if(loginUser.getUserNum() == reservationResult.getUserNum()) {
								System.out.println("내 예약 번호: " + r.getReservationId()+"\n");
							}
						}
							 message = new String("취소 하실 예매 번호를 입력하세요.");
							 reservationId = ScannerUtil.nextInt(scanner, message);

							 reservationResult = resverationSelectOne(reservationId);
								
								message = new String("예매를 삭제하시겠습니까? (y/n)");
								
								String yesNo = ScannerUtil.nextLine(scanner, message);
								if (yesNo.equalsIgnoreCase("y")) {
									System.out.println("삭제 되었습니다.");
									reservationDelete(reservationResult);
								}
							 
							System.out.println("________________________");
						}
					}

				} else if (gradeType == 0) {
					System.out.println();
					System.out.println("________________________");
					System.out.println();
					System.out.println("     관리자 페이지        ");
					System.out.println();

					while (true) {
						message = new String("1. 영화 리스트\n2. 로그아웃");
						userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);
						if (userChoice == 1) {
							System.out.println();
							System.out.println("________________________");
							System.out.println();
							while (true) {
								message = new String("1. 조회\n2. 등록\n3. 수정\n4. 삭제\n5. 관리자페이지로");
								userChoice = ScannerUtil.nextInt(scanner, message, 1, 5);
								if (userChoice == 1) {
										
										list();
										select();
										
								} else if (userChoice == 2) { //영화 등록
									viewMoveRegist();
									
								} else if (userChoice == 3) { //영화 수정
					
									viewMovieEdit();
							
								} else if (userChoice == 4) {
									
									viewMovieDelete();
									
								} else if (userChoice == 5) {
									System.out.println();
									System.out.println("________________________");
									System.out.println();
									System.out.println(" 관리자 페이지 ");
									System.out.println();
									break;
								}
								
							} //관리자 페이지 영화관리 while 끝
							
						} else if (userChoice == 2) {
								System.out.println();
								System.out.println("____________________");
								System.out.println(" 메인 페이지 ");
								System.out.println();
								break;
								
							}
						  } // while문 끝
					
						} else if (userChoice == 3) {
							System.out.println();
							System.out.println("*****************************************************");
							System.out.println("*                                                   *");
							System.out.println("* 종료되었습니다. *");
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
		System.out.println("영화 삭제");
		System.out.println();
		list();
		

		message = new String("삭제할 영화 번호를 입력하세요.");
		movieIdx = ScannerUtil.nextInt(scanner, message);
		
		movieDto = movieSelectOne(movieIdx);
		
		message = new String("선택한 영화를 삭제하시겠습니까? (y/n)");
		
		String yesNo = ScannerUtil.nextLine(scanner, message);
		if (yesNo.equalsIgnoreCase("y")) {
			System.out.println("삭제 되었습니다.");
			movieDelete(movieDto);
		}
	}

	private void viewMoveRegist() {
		String message;
		MovieInfoDTO m = new MovieInfoDTO();
		System.out.println();
		System.out.println("________________________");
		System.out.println();
		System.out.println("영화 등록");
		System.out.println();

		message = new String("제목: ");
		m.setMovieName(ScannerUtil.nextLine(scanner, message));

		message = new String("상영시간: ");
		m.setRunningTime(ScannerUtil.nextLine(scanner, message));

		message = new String("감독: ");
		m.setDirecter(ScannerUtil.nextLine(scanner, message));

		message = new String("장르: ");
		m.setMovieGenre(ScannerUtil.nextLine(scanner, message));

		message = new String("줄거리: ");
		m.setMovieSummary(ScannerUtil.nextLine(scanner, message));

		message = new String("가격: ");
		m.setMoviePrice(ScannerUtil.nextInt(scanner, message));

		addMovie(m);
	}

	private void viewMovieEdit() {
		String message;
		System.out.println();
		System.out.println("________________________");
		System.out.println();
		System.out.println("영화 수정");
		System.out.println();

		list();

		message = new String("수정하실 영화 번호를 입력하세요");
		movieIdx = ScannerUtil.nextInt(scanner, message);
		
		movieDto = movieSelectOne(movieIdx);
		
		message = new String("제목: ");
		movieDto.setMovieName(ScannerUtil.nextLine(scanner, message));

		message = new String("상영시간: ");
		movieDto.setRunningTime(ScannerUtil.nextLine(scanner, message));

		message = new String("감독: ");
		movieDto.setDirecter(ScannerUtil.nextLine(scanner, message));

		message = new String("장르: ");
		movieDto.setMovieGenre(ScannerUtil.nextLine(scanner, message));

		message = new String("줄거리: ");
		movieDto.setMovieSummary(ScannerUtil.nextLine(scanner, message));

		message = new String("가격: ");
		movieDto.setMoviePrice(ScannerUtil.nextInt(scanner, message));

		movieUpdate(movieDto);
	}

	// 회원가입 시 중복된 값 유효성 검사 하기
	public boolean validateUsername(UserDTO user) {
		for (UserDTO u : userList) {
			if (u.getUserId().equals(user.getUserId())) {
				return true;
			}
		}
		return false;
	}

	// 로그인시 userList에 추가하기, 유저 idx +1 하기.
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

	// 로그인 유효성 검사
	public UserDTO auth(UserDTO user) {
		for (UserDTO u : userList) {
			if (u.getUserId().equals(user.getUserId()) && u.getUserPassword().equals(u.getUserPassword())) {
				return u;
			}
		}
		return null;
	}

	// 영화 전체 리스트 출력
	public ArrayList<MovieInfoDTO> printAll() {
		for (MovieInfoDTO m : movieList) {

		}
		return movieList;
	}

	// 영화 하나 선택
	public MovieInfoDTO movieSelectOne(int movieId) {
		for (MovieInfoDTO m : movieList) {
			if (m.getMovieId() == movieId) {
				return m;
			}
		}
		return null;
	}

	// 영화 등록
	public void addMovie(MovieInfoDTO m) {
		m.setMovieId(movieIdx++);

		movieList.add(m);
	}

	// 영화 수정
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

	// 영화 삭제
	public void movieDelete(MovieInfoDTO m) {
		movieList.remove(m);
	}

	//예약 추가
	public void reservationAdd(ReservationDTO r) {
		r.setReservationId(reservationId++);
		resList.add(r);
	}
	
	//예약 삭제
	public void reservationDelete(ReservationDTO r) {
		resList.remove(r);
		
	}
	
	// 예약 하나 선택
	public ReservationDTO  resverationSelectOne(int resverationId) {
		for (ReservationDTO r : resList) {
			if (r.getReservationId() == resverationId) {
				return r;
			}
		}
		return null;
	}
	
	
	// 영화 리스트(이건 유저, 관리자 다 필요해서 메소드로 따로 뻄)
	public void list() {

		movieList = printAll();

		if (movieList.isEmpty()) {
			System.out.println();
			System.out.println("________________________");
			System.out.println();
			System.out.println("등록된 영화가 없습니다. 영화를 등록해주세요");
			System.out.println();
			System.out.println("________________________");
			System.out.println();
		}
		System.out.println();
		System.out.println("________________________");
		System.out.println();
		for (MovieInfoDTO m : movieList) {
			System.out.printf("Id: %d  영화제목: %s\n", m.getMovieId(), m.getMovieName());
		}
	}

	public void select() {
		System.out.println();
		System.out.println("________________________");
		System.out.println();
		String message;
		while (true) {
			message = new String("1. 번호로조회\n2. 검색으로조회\n3. 이전으로");
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
			if (userChoice == 1) {
				numberMovieList();
			} else if (userChoice == 2) {
				searchMovieList(message);
			} else if (userChoice == 3) {
				System.out.println();
				System.out.println("________________________");
				System.out.println();
				System.out.println(" 이전으로 !! ");
				System.out.println();
				break;
			}

		}
	}
	
	//번호로 조회
	public void numberMovieList() {
		String message;
		message = new String("영화 번호를 선택하세요");
		movieIdx = ScannerUtil.nextInt(scanner, message);

		movieDto = movieSelectOne(movieIdx);

		System.out.println();
		System.out.println("________________________");
		System.out.println();
		System.out.println("     선택한 영화    ");
		System.out.println();
		System.out.printf("제목: %s\n상영시간: %s\n감독: %s\n장르: %s\n줄거리: %s\n가격: %d\n", movieDto.getMovieName(), movieDto.getRunningTime(),
				movieDto.getDirecter(), movieDto.getMovieGenre(), movieDto.getMovieSummary(), movieDto.getMoviePrice());
		System.out.println();
		System.out.println("________________________");
		System.out.println();
	}
	
	public void searchMovieList(String search) {
		String message;
		while (true) {
			message = new String("1. 제목으로검색\n2. 감독명으로조회\n3. 장르로검색\n4.이전으로");
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);
			if (userChoice == 1) {
				message = new String("제목입력:");
				search = ScannerUtil.nextLine(scanner, message);
				MovieInfoDTO titleSearch = null;

				for (MovieInfoDTO m : movieList) {
					if (m.getMovieName().equals(search)) {
						titleSearch = m;
						System.out.println("------------- 검색 결과 ------------------");
						System.out.printf("Id: %d  영화제목: %s\n", titleSearch.getMovieId(), titleSearch.getMovieName());
						System.out.println("----------------------------------------");
					}

					if (!m.getMovieName().equals(search)) {
						System.out.println("일치하는 결과가 없습니다.");
					}

				}

			} else if (userChoice == 2) {
				message = new String("감독명입력:");
				search = ScannerUtil.nextLine(scanner, message);
				MovieInfoDTO titleSearch = null;

				for (MovieInfoDTO m : movieList) {
					if (m.getDirecter().equals(search)) {
						titleSearch = m;
						System.out.println("------------- 검색 결과 ------------------");
						System.out.printf("Id: %d  영화제목: %s\n", titleSearch.getMovieId(), titleSearch.getMovieName());
						System.out.println("----------------------------------------");
					}

					if (!m.getDirecter().equals(search)) {
						System.out.println("일치하는 결과가 없습니다.");
					}

				}
			} else if (userChoice == 3) {
				message = new String("장르입력:");
				search = ScannerUtil.nextLine(scanner, message);
				MovieInfoDTO titleSearch = null;

				for (MovieInfoDTO m : movieList) {
					if (m.getMovieGenre().equals(search)) {
						titleSearch = m;
						System.out.println("------------- 검색 결과 ------------------");
						System.out.printf("Id: %d  영화제목: %s\n", titleSearch.getMovieId(), titleSearch.getMovieName());
						System.out.println("----------------------------------------");
					}

					if (!m.getMovieGenre().equals(search)) {
						System.out.println("일치하는 결과가 없습니다.");
					}

				}
			} else if (userChoice == 4) {
				System.out.println();
				System.out.println("________________________");
				System.out.println();
				System.out.println(" 이전으로 !! ");
				System.out.println();
				break;

			}
		}
	}
	
}
