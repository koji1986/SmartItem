package dao;

import java.util.List;

import domain.PicRank;

public interface PicRankDao {

	List<PicRank> findAll() throws Exception;

	PicRank findById(Integer id) throws Exception;

	void insert(PicRank picRank) throws Exception;

	void update(PicRank picRank) throws Exception;

	void delete(PicRank picRank) throws Exception;

}
