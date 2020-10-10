# maeding machine

自動販売機。

# 環境/技術

- Kotlin
	- ktor
- MySQL 5.7
	- migration: [golang-migration/migrate](https://github.com/golang-migrate/migrate)
- [GraphQL](https://graphql.org/)
	- [graphql/graphiql](https://github.com/graphql/graphiql)
- Docker, Docker Compose

# 仕様

- ドリンク
	- 名前
	- 画像
	- 缶 / ペット
	- サイズ(ml数)
	- 値段
	- 提供可能 温度  (冷 / 温 / 常温)
- ベンディングマシン
	- 3x5
		- ドリンク
		- 購入可能(残り本数)
		- 冷 / 温 / 常温
		- 購入可能かどうかのみ表示
		- 同じドリンク && 温度 があった場合は、同じ扱いする
	- たまに当たる
		- くじ付き
		- おまけ1本
	- お金(**実装できず**)
		- ユーザ毎にセッション持つ(10分)
		- 投入金額自由
		- 買ったらお釣り出る
	- 売れ行きのログ取りたい

# [ER図](https://dbdiagram.io/d/5e0f1ab4edf08a25543f951b)

![ER図](images/maeding_machine.png)

# Build

## migration

runでcmd渡したいなぁ。(次回)

```
$ docker-compose run migrate
```

## server

```
$ pwd
/path/to/mading-machine/server

# local run 
$ ./gradlew run

# build
$ ./gradlew build

# docker build
$ ./gradlew build
$ docker build -t wed/maeding-machine .
```

## docker compose

```
$ pwd
/path/to/mading-machine

$ docker-compose up --build
```

# Local Debug

serverを立ち上げて、GraphiQLにアクセス！

```
$ pwd
/path/to/mading-machine/server

$ ./gradlew run
$ open http://localhost:8080/graphiql
```


## 参考

- https://github.com/camuthig/ktor-social-graphql/
