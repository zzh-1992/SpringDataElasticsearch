##
```shell
[2023-08-02 06:42:31.665] [restartedMain] DEBUG com.grapefruit.springdataelasticsearch.mapper.BookMapper.insertBatchSomeColumn - ==>  Preparing: INSERT INTO books (id,name,summary,price) VALUES (?,?,?,?) , (?,?,?,?) , (?,?,?,?) , (?,?,?,?) , (?,?,?,?) , (?,?,?,?) , (?,?,?,?) , (?,?,?,?) , (?,?,?,?) , (?,?,?,?)
```

```shell
[2023-08-02 06:42:31.682] [restartedMain] WARN  com.clickhouse.jdbc.internal.SqlBasedPreparedStatement - Please consider to use one and only one values expression, for example: use 'values(?)' instead of 'values(?),(?)'.
```

chatgpt
```shell
String sql = "INSERT INTO table_name (column1, column2) VALUES (?, ?)";
PreparedStatement pstmt = connection.prepareStatement(sql);
pstmt.setString(1, value1);
pstmt.setInt(2, value2);
// 如果需要插入多行，可以再添加更多参数
// pstmt.setString(3, value3);
// pstmt.setInt(4, value4);
pstmt.executeUpdate();

```
