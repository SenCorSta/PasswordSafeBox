package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.AccountBase;




public interface AccountBaseMapper {
    /**
     * 插入一条记录
     * @param AccountBase
     * @return 
     */
    int insert(AccountBase accountBase);
    
    /**
     * 查询所有
     * @param accountBase 
     * @return
     */
    @Select(value ={"select * from t_account_base where username=#{username}"})
    List<AccountBase> queryAll(AccountBase accountBase);
	
	@Update(value = { "update t_account_base set name=#{name},kind=#{kind},account=#{account},password=#{password},annotation=#{annotation},salt=#{salt} where id=#{id} and username=#{username}" })
	int modifyByID(AccountBase accountBase);
	
	@Delete(value = { "DELETE FROM t_account_base WHERE id = #{id} and username=#{username}" }) 
	int deleteByID(AccountBase accountBase);
	
	@Select(value ={"select * from t_account_base where username=#{username} and name like #{name}"})
	List<AccountBase> queryByName(AccountBase accountBase);
	
	
}
