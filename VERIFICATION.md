# Lexicon 恢复核对记录

服务使用 Java 8、Maven 3.6.3、Spring Boot 2.1.0 和 MySQL 5.7.42。拆分前从当前运行数据库重新导出 `data/current-lexicon.sql`，并在独立的数据卷中导入。七张表的精确行数：

| 表 | 行数 |
| --- | ---: |
| concept | 128,740 |
| domain | 1 |
| leff_sem | 1,126,306 |
| rel | 238,232 |
| sense | 123,232 |
| word | 158,139 |
| wordform | 549,230 |

新旧实例的七张表均使用 `CHECKSUM TABLE ... EXTENDED` 核对，校验值逐表一致；`wordform.id` 仍为自增主键。当前备份的 SHA256 为 `66F6E142402071271D430C63439B7BA3DFBA610374FDAB8B9BDE1EA6871E6CDA`。

V11 源码与 2019 年原备份有三处实际不匹配，恢复副本已做最小兼容修正：原备份的 `wordform` 没有 JPA 所需的自增 `id`；未使用的 Axon 和 Spring Batch 依赖会使 JPA 期待不存在的表；部分历史列类型与实体声明不同，因此关闭自动建表和改表。当前导出的数据库已有 `wordform.id`，保留历史备份不修改。

首页、词条及概念详情、列表页和代表性 GET API 已通过检查。新增、修改、删除仅在可丢弃的测试数据库中验证过。本机版本没有身份验证，服务只绑定回环地址。
