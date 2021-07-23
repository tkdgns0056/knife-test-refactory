package kr.kassadin.knife.vo;

public class MovieInfoDTO {
    // 영화번호 (아래의 정보를 저장할)
    private int movieId;
    // 영화제목
    private String movieName;
    // 영화 상영시간
    private String runningTime;
    // 영화 장르
    private String movieGenre;
    // 영화 줄거리
    private String movieSummary;
    //감독
    private String directer;
    //가격
    private int moviePrice;
    
    // Getter, Setter
    
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getRunningTime() {
        return runningTime;
    }
    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }
    
    public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieSummary() {
        return movieSummary;
    }
    public void setMovieSummary(String movieSummary) {
        this.movieSummary = movieSummary;
    }
    public String getDirecter() {
		return directer;
	}
	public void setDirecter(String directer) {
		this.directer = directer;
	}
	public int getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}
	// equals() MovieInfo
    public boolean equals(Object o) {
        if(o instanceof MovieInfoDTO) {
            MovieInfoDTO m = (MovieInfoDTO)o;
            if(movieId == m.movieId) {
                return true;
            }
        }
        return false;
    }
    
}