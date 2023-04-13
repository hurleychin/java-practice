PostgreSQL中的JSONB类型可以像其他数据类型一样进行条件查询，例如：

1. 等于某个值：

```sql
SELECT * FROM table_name WHERE jsonb_column = '{"key": "value"}';
```

2. 包含某个键：

```sql
SELECT * FROM table_name WHERE jsonb_column ? 'key';
```

3. 包含某个键且该键对应的值等于某个值：

```sql
SELECT * FROM table_name WHERE jsonb_column @> '{"key": "value"}';
```

4. 包含某个数组元素：

```sql
SELECT * FROM table_name WHERE jsonb_column -> 'array_key' @> '"value"';
```

5. 包含某个元素（无论在什么位置）：

```sql
SELECT * FROM table_name WHERE jsonb_column @> '{"key": "value"}';
```

6. 其他高级查询：

```sql
SELECT * FROM table_name WHERE jsonb_column -> 'key' IS NOT NULL AND jsonb_column ->> 'key' LIKE 'prefix%';
```

需要注意的是，在使用JSONB类型进行条件查询时，应该避免使用通配符操作符（如LIKE），因为这会导致性能下降。为了优化查询性能，建议使用GIN或B-tree索引。