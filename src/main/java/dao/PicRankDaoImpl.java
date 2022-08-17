package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.PicRank;

public class PicRankDaoImpl implements PicRankDao {

	private DataSource ds;

	public PicRankDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<PicRank> findAll() throws Exception {
		List<PicRank> picRankList = new ArrayList<>();
		try {
			Connection con = ds.getConnection();
			String sql = "  select pic_rank.id,shop_inf.shopInf_name,pic_rank.picRank_name,\n"
					+ "pic_rank.picRank_fee,pic_rank.picRank_row\n" + "from pic_rank\n"
					+ "join shop_inf on pic_rank.shopInf_id=shop_inf.id; ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				picRankList.add(mapToPicRank(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return picRankList;
	}

	@Override
	public PicRank findById(Integer id) throws Exception {
		PicRank picRank = new PicRank();
		try {
			Connection con = ds.getConnection();
			String sql = " select shop_inf.shopInf_name,pic_rank.picRank_name,\n"
					+ "pic_rank.picRank_fee,pic_rank.picRank_row\n" + "from pic_rank\n"
					+ "join shop_inf on pic_rank.shopInf_id=shop_inf.id where pic_rank.id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				picRank = mapToPicRank(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return picRank;
	}

	@Override
	public void insert(PicRank picRank) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(PicRank picRank) throws Exception {
		try {
			Connection con = ds.getConnection();
			String sql = "  update pic_rank set shopInf_id=?,picRank_name=?,\n"
					+ "picRank_fee=?,picRank_row=? where id=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, picRank.getShopInfId(), Types.INTEGER);
			stmt.setString(2, picRank.getPicRankName());

			stmt.setObject(3, picRank.getPicRankFee(), Types.INTEGER);
			stmt.setObject(4, picRank.getPicRankRow(), Types.INTEGER);
			stmt.setObject(5, picRank.getId(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(PicRank picRank) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private PicRank mapToPicRank(ResultSet rs) throws Exception {

		Integer id = (Integer) rs.getObject("id");
		String shopInfName = rs.getString("shopInf_name");
		String picRankName = rs.getString("picRank_name");
		Integer picRankFee = (Integer) rs.getObject("picRank_fee");

		Integer picRankRow = (Integer) rs.getObject("picRank_row");

		return new PicRank(id, shopInfName, picRankName, picRankFee, picRankRow);

	}

}
