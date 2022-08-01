package domain;

import java.util.Date;

public class Pic {

	private Integer id;
	private Integer picRankIdA;
	private String picNameA;
	private String picKanaA;
	private Integer picRankIdB;
	private String picNameB;
	private String picKanaB;
	private String picPhoneNumber;
	private String picEmail;
	private String picAddress;
	private Date picEntryDay;
	private Date picOutDay;
	private String picMemo;

	public Pic(Integer id, Integer picRankIdA, String picNameA, String picKanaA, Integer picRankIdB, String picNameB,
			String picKanaB, String picPhoneNumber, String picEmail, String picAddress, Date picEntryDay,
			Date picOutDay, String picMemo) {
		super();
		this.id = id;
		this.picRankIdA = picRankIdA;
		this.picNameA = picNameA;
		this.picKanaA = picKanaA;
		this.picRankIdB = picRankIdB;
		this.picNameB = picNameB;
		this.picKanaB = picKanaB;
		this.picPhoneNumber = picPhoneNumber;
		this.picEmail = picEmail;
		this.picAddress = picAddress;
		this.picEntryDay = picEntryDay;
		this.picOutDay = picOutDay;
		this.picMemo = picMemo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPicRankIdA() {
		return picRankIdA;
	}

	public void setPicRankIdA(Integer picRankIdA) {
		this.picRankIdA = picRankIdA;
	}

	public String getPicNameA() {
		return picNameA;
	}

	public void setPicNameA(String picNameA) {
		this.picNameA = picNameA;
	}

	public String getPicKanaA() {
		return picKanaA;
	}

	public void setPicKanaA(String picKanaA) {
		this.picKanaA = picKanaA;
	}

	public Integer getPicRankIdB() {
		return picRankIdB;
	}

	public void setPicRankIdB(Integer picRankIdB) {
		this.picRankIdB = picRankIdB;
	}

	public String getPicNameB() {
		return picNameB;
	}

	public void setPicNameB(String picNameB) {
		this.picNameB = picNameB;
	}

	public String getPicKanaB() {
		return picKanaB;
	}

	public void setPicKanaB(String picKanaB) {
		this.picKanaB = picKanaB;
	}

	public String getPicPhoneNumber() {
		return picPhoneNumber;
	}

	public void setPicPhoneNumber(String picPhoneNumber) {
		this.picPhoneNumber = picPhoneNumber;
	}

	public String getPicEmail() {
		return picEmail;
	}

	public void setPicEmail(String picEmail) {
		this.picEmail = picEmail;
	}

	public String getPicAddress() {
		return picAddress;
	}

	public void setPicAddress(String picAddress) {
		this.picAddress = picAddress;
	}

	public Date getPicEntryDay() {
		return picEntryDay;
	}

	public void setPicEntryDay(Date picEntryDay) {
		this.picEntryDay = picEntryDay;
	}

	public Date getPicOutDay() {
		return picOutDay;
	}

	public void setPicOutDay(Date picOutDay) {
		this.picOutDay = picOutDay;
	}

	public String getPicMemo() {
		return picMemo;
	}

	public void setPicMemo(String picMemo) {
		this.picMemo = picMemo;
	}

}
