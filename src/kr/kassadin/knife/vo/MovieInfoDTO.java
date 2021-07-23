package kr.kassadin.knife.vo;

public class MovieInfoDTO {
    // ��ȭ��ȣ (�Ʒ��� ������ ������)
    private int movieId;
    // ��ȭ����
    private String movieName;
    // ��ȭ �󿵽ð�
    private String runningTime;
    // ��ȭ �帣
    private String movieGenre;
    // ��ȭ �ٰŸ�
    private String movieSummary;
    //����
    private String directer;
    //����
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