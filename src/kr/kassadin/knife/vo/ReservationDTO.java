package kr.kassadin.knife.vo;

public class ReservationDTO {
	private int userNum;
    private int reservationId;
    private int row;
    private int column;
    private int Total;
    private int movieIdx;
    
    // Getter, Setter
    
    public int getReservationId() {
        return reservationId;
    }
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
    public int getTotal() {
        return Total;
    }
    public void setTotal(int total) {
        Total = total;
    }

	public int getMovieIdx() {
		return movieIdx;
	}
	public void setMovieId(int movieIdx) {
		this.movieIdx = movieIdx;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	// equals() ScreenInfo
    public boolean equals(Object o) {
        if(o instanceof ReservationDTO) {
            ReservationDTO r = (ReservationDTO)o;
            if(reservationId == r.reservationId) {
                return true;
            }
        }        
        return false;
    }
    
    
    
}