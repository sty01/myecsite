set names utf8;
set foreign_key_checks = 0;
drop database if exists ecsitetwo;

create database if not exists ecsitetwo;
use ecsitetwo;

drop table if exists login_user_transaction;

create table login_user_transaction(
	id int not null primary key auto_increment,
	login_id varchar(16) unique,
	login_pass varchar(16),
	user_name varchar (50),
	admin_flg varchar(1),
	insert_date datetime,
	updated_date_ datetime
	);

	drop table if exists item_info_transaction;

	create table item_info_transaction(
	id int not null primary key auto_increment,
	item_name varchar(30),
	item_price int,
	item_stock int,
	item_info varchar(255),
	insert_date datetime,
	update_date datetime
	);

	drop table if exists user_buy_item_transaction;

	create table user_buy_item_transaction(

	id int not null primary key auto_increment,
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),
	insert_date datetime,
	delete_date datetime
	);

	drop table if exists cart;

	create table cart(
	cart_id int not null primary key auto_increment,
	item_id int,
	item_count int,
	user_master_id varchar(16),
	subtotal int,
	pay varchar(16),
	insert_date datetime
	);


	INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_info) VALUES("NoteBook",100,50,"●消しゴムできれいに消しやすい、小学生の筆記に最適な紙を開発・採用したノートです。
●画数の多い細かい文字もよりくっきりなめらかに筆記できます。(当社従来品比)
●途中でページを破ってもバラけにくい無線とじ製本を採用しました。
●筆記時における目の疲労感が少ない白さの中紙を開発・採用しました。
●使いやすい科目シール付きです。
●中紙に森林認証紙を使用しています。(中性紙)
●青・ライトグリーン・紫・ピンク・ライトイエローの5色パックで、教科ごとに色分けして使うのに便利です。");
	INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_info) VALUES("Pen",120,60,"ノック1回で3倍長く書き続けられる。
オレンズは、芯の減りに合わせて先端パイプがスライド。
先端パイプの分だけ長く書けるため、ノック1回の筆記量が一般的なシャープペンシルの4倍書ける。
英文の書き起こしや漢字練習など、とにかく文字をたくさん書く場面で力を発揮。

不思議なほど、芯が折れない。
「芯を出さないで書く」という使い方を可能にしたため、力をこめても芯が折れない。
芯が折れるストレスがないので、作文やレポートの清書などの場面でも集中力が途切れない。");

INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_info) VALUES("ReportPaper",120,65,"●提出する際に便利なレポートタイプのキャンパス音楽帳です。
●厚口のA4用紙なので、はぎ取った後もしわになりにくく保管しやすくなっています。
●サイズ/A4(210×297mm)
●罫内容/五線譜・12段
●印刷/片面印刷
●中紙/上質紙(厚口85g/m2)●製本様式/天糊クロス巻き");

INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_info) VALUES("Folder",120,70,"「クリアーファイル」Pasty から、テーマ別のカラーセットをご提案
おししそうなフルーツジェラートの4色を選びました。
ラズベリーピンク・チェリーピンク・ピーチピンク・バニラホワイト
・酸味さわやか ラズベリーピンク
・しっかり甘い チェリーピンク
・やさしい甘さ ピーチピンク
・香りが甘い バニラホワイト");

INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_info) VALUES("Eraser",38,450,"多孔質セラミックスパウダーの働きで、
いつもカドで消す感触の消しゴム。
 消しゴム粒子が鉛筆の黒鉛粒子を包み込んで、筆跡をきれいに消します。
力任せにしなくても、きれいに消えるので、紙を痛めません。");

INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_info) VALUES("PlayColorDot",1235,850,"水性ツインサインペン「プレイカラードット」の12色入りセット。
やわらかソフトカラーの丸スタンプ芯と、くっきりブライトカラーの0.3mm超極細芯のツインタイプ。
イラストや絵手紙、ノートや手帳など、丸スタンプと超極細ラインの組み合わせで、様々な使い方が出来る。");

INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_info) VALUES("WhiteBoardMat",2700,350,"●表面の光の反射を抑えたマットタイプのマグネットホワイトボードです。会議や授業中にプロジェクタで投影しながら書き込むことができます。
天井の照明の写りこみも軽減でき、カメラなどでの議事録撮影に便利です。●当社従来品比で約６割も軽量化！だからホワイトボードの無い場所へ移動させたり持ち運んだりしやすくなりました。学校や研修でのグループワーク・発表などにも最適です。");

INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_info) VALUES("Tape",530,350,"高い粘着力と抜群の保持力。巻戻しも軽く、しなやかで手切れも良く、作業性に優れている。無溶剤タイプの粘着剤と古紙配合率100%の巻心を使用。
環境に配慮した布粘着テープ");

INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_info) VALUES("PenCase",2234,350,"高級牛革を採用、飽きのこないシンプルなデザイン。自分用でもプレゼント用も最高！
シンプルながらも、デザイン性と実用性を兼ね備えて長くご愛用頂けます。
植物なめし仕上げ、環境にやさしく、革本来の魅力を味わいましょう！ ");

INSERT INTO item_info_transaction(item_name,item_price,item_stock,item_info) VALUES("Diary",3456,30,"■■情報の整理＆検索が楽になる、24時間バーチカル手帳「ジブン手帳Biz」に4月始まりが登場■■
年度始まりの4月に手帳を切り替えたいビジネスマンや、新学期から手帳を使い始めたい学生の方にもおすすめです。");


INSERT INTO login_user_transaction(login_id,login_pass,user_name,admin_flg) VALUES("internous","internous01","test","0");
INSERT INTO login_user_transaction(login_id,login_pass,user_name,admin_flg) VALUES("admin","admin","admin","1");
INSERT INTO login_user_transaction(login_id,login_pass,user_name,admin_flg) VALUES("aa","aabbcc","aa","0");


