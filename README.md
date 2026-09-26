# Yseop Lexicon 词库网站与 API

**2019 年最终实习报告：**[阅读 PDF](docs/Rapport_de_stage_DENG_Yaqi.pdf)。报告同时介绍 Lexicon 网站／API 和 MeSH–WordNet 概念匹配实验，记录的是当年的工作。

这个项目保存实习中的 V11 Java 词库浏览器和原有 `/api` 接口。它独立于 MeSH–WordNet 实验：当前数据库没有导入该实验的候选配对。仓库公开代码和上述实习报告；数据库备份只保存在本机，且不附带开源许可证。

## 启动

先启动 Docker Desktop，在本目录运行：

```powershell
docker compose up -d --build db app
docker compose --profile check run --rm smoke
```

打开 [本机词库网站](http://127.0.0.1:18080/)。可直接查看 [词条](http://127.0.0.1:18080/word/1)、[概念](http://127.0.0.1:18080/concept/1)和 [词条 API](http://127.0.0.1:18080/api/word/id/1)。网站只监听 `127.0.0.1:18080`；本机无需安装 Java、MySQL 或 Python。第二条命令用独立的检查容器核验页面和代表性 GET API。

本目录的私有 `.env` 提供数据库密码。若复制到新电脑且未带上它，按 `.env.example` 新建 `.env` 并设置两个不同的随机密码。`data/current-lexicon.sql` 是拆分项目时从正在运行的数据库导出的备份；首次创建数据卷时会自动导入。`data/lexicon-2019.sql` 是保留的历史原始备份；当前备份已含 `wordform.id`，不要再对当前数据库执行 `data/02-wordform-id.sql`。公开仓库不含这些备份，克隆后需自行提供有权使用的数据库备份，才能按上述步骤启动网站。

停止服务用 `docker compose down`，数据卷会保留。数据库备份和 `.env` 被 Git 忽略，请保持私有。七张表的核对结果和兼容性修复见 [VERIFICATION.md](VERIFICATION.md)。
