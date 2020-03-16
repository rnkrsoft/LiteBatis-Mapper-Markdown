```
-- $namespace=com.rnkrsoft.litebatis.demo.mapper.DemoMapper
```

# 用户信息
## 增加用户信息
```sql
-- 增加用户信息
-- $type=insert
-- $paramType=com.rnkrsoft.litebatis.demo.DemoEntity
insert into demo(name, age, sex) value(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, #{sex,jdbcType=INTEGER})
```


## 删除用户信息
```sql
-- 删除用户信息
-- $type=delete
-- $id=deleteUser
-- $paramType=com.rnkrsoft.litebatis.demo.DemoEntity
delete from demo where userid = #{userid,jdbcType=INTEGER} and  age > #{age,jdbcType=INTEGER}
```

## 修改用户信息
```sql
-- 修改用户信息
-- $type=update
-- $id=updateUserByPrimaryKey
-- $paramType=com.rnkrsoft.litebatis.demo.DemoEntity
update demo set name=#{name,jdbcType=VARCHAR},age=#{age,jdbcType=INTEGER} where sex = #{sex,jdbcType=INTEGER}
-- @if(sex > 10)
and sex = #{sex,jdbcType=INTEGER}
-- @endif
```

## 查询用户信息
```sql
-- 用户信息
-- $type=select
-- $id=selectUser查询用户信息
-- $resultType=com.rnkrsoft.litebatis.demo.DemoEntity
-- $paramType=com.rnkrsoft.litebatis.demo.DemoEntity
select username, age, sex 
from demo 
where username = #{username,jdbcType=VARCHAR} 
and age > #{age,jdbcType=INTEGER}
-- @if(sex > 0)
and sex > #{sex,jdbcType=INTEGER}
-- @endif
-- @if(address != null)
and address = #{address,jdbcType=VARCHAR}
-- @endif
```