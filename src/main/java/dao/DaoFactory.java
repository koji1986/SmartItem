package dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DaoFactory {

	public static AdminsDao createAdminsDao() {
		return new AdminsDaoImpl(getDataSource());
	}

	public static SalesDao createSalesDao() {
		return new SalesDaoImpl(getDataSource());
	}

	public static CostDao createCostDao() {
		return new CostDaoImpl(getDataSource());
	}

	public static CustomerDao createCustomerDao() {
		return new CustomerDaoImpl(getDataSource());
	}

	public static PicDao createPicDao() {
		return new PicDaoImpl(getDataSource());
	}

	public static CourseDao createCourseDao() {
		return new CourseDaoImpl(getDataSource());
	}

	public static OptionDao createOptionDao() {
		return new OptionDaoImpl(getDataSource());
	}

	public static AdDao createAdDao() {
		return new AdDaoImpl(getDataSource());
	}

	public static DiscountDao createDiscountDao() {
		return new DiscountDaoImpl(getDataSource());
	}

	public static PicRankDao createPicRankDao() {
		return new PicRankDaoImpl(getDataSource());
	}

	public static StaffDao createStaffDao() {
		return new StaffDaoImpl(getDataSource());
	}

	public static CashDao createCashDao() {
		return new CashDaoImpl(getDataSource());
	}

	public static ShopInfDao createShopInfDao() {
		return new ShopInfDaoImpl(getDataSource());
	}

	public static CustomerCategolyDao createCustomerCategolyDao() {
		return new CustomerCategolyDaoImpl(getDataSource());
	}

	public static CostSubjectDao createCostSubjectDao() {
		return new CostSubjectDaoImpl(getDataSource());
	}

	private static DataSource getDataSource() {
		InitialContext ctx = null;
		DataSource ds = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/smart_item_db");
		} catch (NamingException e) {
			if (ctx != null) {
				try {
					ctx.close();
				} catch (NamingException e1) {
					throw new RuntimeException(e1);
				}
			}
			throw new RuntimeException(e);
		}
		return ds;
	}

}
