package mvc.domain;

public class CarPickDTO {
	//car
	private int car_id;
	private String model_name;
	private String car_pic;
	private int price_id;
	private int brand_id;
	private int cartype_id;
	private int production_id;
	private String years;
	private int price;
	private String fuel;
	private String effiiency;
	private String output;
	private String exh;
	private String engine;
	private String shift;
	private String length;
	private String heigth;
	private String width;
	private String wheelbase;
	//car_review
	private String review_writer;
	private String review_content;
	private String review_writedate;
	private float review_grade;
	//board
	int board_no;
	String board_subject;
	String board_content;
	String board_writedate;
	
	//car dto
	public CarPickDTO(int car_id, String model_name, String car_pic, int price_id, int brand_id, int cartype_id,
			int production_id, String years, int price, String fuel, String effiiency, String output, String exh,
			String engine, String shift, String length, String heigth, String width, String wheelbase) {
		super();
		this.car_id = car_id;
		this.model_name = model_name;
		this.car_pic = car_pic;
		this.price_id = price_id;
		this.brand_id = brand_id;
		this.cartype_id = cartype_id;
		this.production_id = production_id;
		this.years = years;
		this.price = price;
		this.fuel = fuel;
		this.effiiency = effiiency;
		this.output = output;
		this.exh = exh;
		this.engine = engine;
		this.shift = shift;
		this.length = length;
		this.heigth = heigth;
		this.width = width;
		this.wheelbase = wheelbase;
	}

	//car review dto
	public CarPickDTO(int car_id, String review_writer, String review_content, String review_writedate,
			float review_grade) {
		super();
		this.car_id = car_id;
		this.review_writer = review_writer;
		this.review_content = review_content;
		this.review_writedate = review_writedate;
		this.review_grade = review_grade;
	}

	//board dto
	public CarPickDTO(int board_no, String board_subject, String board_content, String board_writedate) {
		super();
		this.board_no = board_no;
		this.board_subject = board_subject;
		this.board_content = board_content;
		this.board_writedate = board_writedate;
	}

	public int getCar_id() {
		return car_id;
	}


	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}


	public String getModel_name() {
		return model_name;
	}


	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}


	public String getCar_pic() {
		return car_pic;
	}


	public void setCar_pic(String car_pic) {
		this.car_pic = car_pic;
	}


	public int getPrice_id() {
		return price_id;
	}


	public void setPrice_id(int price_id) {
		this.price_id = price_id;
	}


	public int getBrand_id() {
		return brand_id;
	}


	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}


	public int getCartype_id() {
		return cartype_id;
	}


	public void setCartype_id(int cartype_id) {
		this.cartype_id = cartype_id;
	}


	public int getProduction_id() {
		return production_id;
	}


	public void setProduction_id(int production_id) {
		this.production_id = production_id;
	}


	public String getYears() {
		return years;
	}


	public void setYears(String years) {
		this.years = years;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getFuel() {
		return fuel;
	}


	public void setFuel(String fuel) {
		this.fuel = fuel;
	}


	public String getEffiiency() {
		return effiiency;
	}


	public void setEffiiency(String effiiency) {
		this.effiiency = effiiency;
	}


	public String getOutput() {
		return output;
	}


	public void setOutput(String output) {
		this.output = output;
	}


	public String getExh() {
		return exh;
	}


	public void setExh(String exh) {
		this.exh = exh;
	}


	public String getEngine() {
		return engine;
	}


	public void setEngine(String engine) {
		this.engine = engine;
	}


	public String getShift() {
		return shift;
	}


	public void setShift(String shift) {
		this.shift = shift;
	}


	public String getLength() {
		return length;
	}


	public void setLength(String length) {
		this.length = length;
	}


	public String getHeigth() {
		return heigth;
	}


	public void setHeigth(String heigth) {
		this.heigth = heigth;
	}


	public String getWidth() {
		return width;
	}


	public void setWidth(String width) {
		this.width = width;
	}


	public String getWheelbase() {
		return wheelbase;
	}


	public void setWheelbase(String wheelbase) {
		this.wheelbase = wheelbase;
	}


	public String getReview_writer() {
		return review_writer;
	}


	public void setReview_writer(String review_writer) {
		this.review_writer = review_writer;
	}


	public String getReview_content() {
		return review_content;
	}


	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}


	public String getReview_writedate() {
		return review_writedate;
	}


	public void setReview_writedate(String review_writedate) {
		this.review_writedate = review_writedate;
	}


	public float getReview_grade() {
		return review_grade;
	}


	public void setReview_grade(float review_grade) {
		this.review_grade = review_grade;
	}


	public int getBoard_no() {
		return board_no;
	}


	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}


	public String getBoard_subject() {
		return board_subject;
	}


	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}


	public String getBoard_content() {
		return board_content;
	}


	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}


	public String getBoard_writedate() {
		return board_writedate;
	}


	public void setBoard_writedate(String board_writedate) {
		this.board_writedate = board_writedate;
	}

}
