package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Pic;

public class PicDaoImpl implements PicDao {

	private DataSource ds;

	public PicDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Pic> findAll() throws Exception {
		List<Pic> picList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = " select pic.id,pic_rank.picRank_name,pic.picRank_idA, pic.pic_nameA,pic.pic_kanaA,\n"
					+ "pic_rank.picRank_name,pic.pic_nameB,pic.picRank_idB, pic.pic_kanaB,\n"
					+ "pic.pic_phone_number,pic.pic_email,pic.pic_address,\n"
					+ "pic.pic_entry_day,pic.pic_out_day,pic.pic_memo\n" + "from pic\n" + "join pic_rank\n"
					+ "on pic.picRank_idA=pic_rank.id ;";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				picList.add(mapToPic(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return picList;
	}

	@Override
	public Pic findById(Integer id) throws Exception {
		Pic pic = new Pic();
		try {
			Connection con = ds.getConnection();
			String sql = " select pic.id,pic_rank.picRank_name,pic.picRank_idA, pic.pic_nameA,pic.pic_kanaA,\n"
					+ "pic_rank.picRank_name,pic.pic_nameB,pic.picRank_idB,pic.pic_kanaB,\n"
					+ "pic.pic_phone_number,pic.pic_email,pic.pic_address,\n"
					+ "pic.pic_entry_day,pic.pic_out_day,pic.pic_memo\n" + "from pic\n" + "join pic_rank\n"
					+ "on pic.picRank_idA=pic_rank.id  where pic.id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				pic = mapToPic(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return pic;
	}

	@Override
	public void insert(Pic pic) throws Exception {

		try {
			Connection con = ds.getConnection();
			String sql = " insert into pic (\n" + "picRank_idA,\n" + "pic_nameA,\n" + "pic_kanaA,\n" + "picRank_idB,\n"
					+ "pic_nameB,\n" + "pic_kanaB,\n" + "pic_phone_number,\n" + "pic_email,\n" + "pic_address,\n"
					+ "pic_entry_day,\n" + "pic_out_day,\n" + "pic_memo)\n" + "values(?,?,?,?,?,?,?,?,?,?,?,?);";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, pic.getPicRankIdA());
			stmt.setString(2, pic.getPicNameA());
			stmt.setString(3, pic.getPicKanaA());
			stmt.setObject(4, pic.getPicRankIdB());
			stmt.setString(5, pic.getPicNameB());
			stmt.setString(6, pic.getPicKanaB());
			stmt.setString(7, pic.getPicPhoneNumber());
			stmt.setString(8, pic.getPicEmail());
			stmt.setString(9, pic.getPicAddress());
			stmt.setObject(10, pic.getPicEntryDay());
			stmt.setObject(11, pic.getPicOutDay());
			stmt.setString(12, pic.getPicMemo());

			stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Pic pic) throws Exception {

		try {
			Connection con = ds.getConnection();
			String sql = " update pic set\n" + "picRank_idA=?,\n" + "pic_nameA=?,\n" + "pic_kanaA=?,\n"
					+ "picRank_idB=?,\n" + "pic_nameB=?,\n" + "pic_kanaB=?,\n" + "pic_phone_number=?,\n"
					+ "pic_email=?,\n" + "pic_address=?,\n" + "pic_entry_day=?,\n" + "pic_out_day=?,\n" + "pic_memo=?\n"
					+ "where id=?;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, pic.getPicRankIdA(), Types.INTEGER);
			stmt.setString(2, pic.getPicNameA());
			stmt.setString(3, pic.getPicKanaA());
			stmt.setObject(4, pic.getPicRankIdB(), Types.INTEGER);
			stmt.setString(5, pic.getPicNameB());
			stmt.setString(6, pic.getPicKanaB());
			stmt.setString(7, pic.getPicPhoneNumber());
			stmt.setString(8, pic.getPicEmail());
			stmt.setString(9, pic.getPicAddress());
			stmt.setObject(10, pic.getPicEntryDay());
			stmt.setObject(11, pic.getPicOutDay());
			stmt.setString(12, pic.getPicMemo());
			stmt.setObject(13, pic.getId(), Types.INTEGER);

			stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Pic pic) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "DELETE FROM pic WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, pic.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	private Pic mapToPic(ResultSet rs) throws Exception {

		Pic pic = new Pic();

		pic.setId((Integer) rs.getObject("id"));
		pic.setPicRankName(rs.getString("picRank_name"));
		pic.setPicRankIdA((Integer) rs.getObject("picRank_idA"));
		pic.setPicNameA(rs.getString("pic_nameA"));
		pic.setPicKanaA(rs.getString("pic_kanaA"));
		pic.setPicRankIdB((Integer) rs.getObject("picRank_idB"));
		pic.setPicNameB(rs.getString("pic_nameB"));
		pic.setPicKanaB(rs.getString("pic_kanaB"));
		pic.setPicPhoneNumber(rs.getString("pic_phone_number"));
		pic.setPicEmail(rs.getString("pic_email"));
		pic.setPicAddress(rs.getString("pic_address"));
		pic.setPicEntryDay(rs.getDate("pic_entry_day"));
		pic.setPicOutDay(rs.getDate("pic_out_day"));
		pic.setPicMemo(rs.getString("pic_memo"));

		return pic;

	}
}
