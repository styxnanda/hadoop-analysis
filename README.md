# <p style="text-align: center;">Hadoop MapReduce</p>

<p align="center">
  <img src="https://images.ctfassets.net/dl64kxf2oxn0/6wXbjyC4yYh9ui51alqSt8/ae11137a0c6b1f363966e7f4ec512492/1_U95c0vlgdmnUOxt7in3BRQ.png" width=350/>
</p>

<p align="center">
  <a href="#anggota-kelompok">Anggota Kelompok</a> •
  <a href="#instalasi-hadoop">Instalasi Hadoop</a> •
  <a href="#menjalankan-hadoop-dan-word-count">Menjalankan Hadoop dan Word Count</a> •
  <a href="#eksperimen-performa-hadoop-mapreduce">Eksperimen Performa Hadoop MapReduce</a> •
  <a href="#analisis-hasil-eksperimen">Analisis Hasil Eksperimen</a>

## Anggota Kelompok

|             Nama              |    NPM     |
| :---------------------------: | :--------: |
|       Althaf Nafi Anwar       | 2106634881 |
|       Muhammad Suhaili        | 2106731535 |
|     Satya Ananda Sulistio     | 2106705524 |
| Sulthan Satrya Yudha Darmawan | 2106731560 |

---

## Instalasi Hadoop

### 1. Download Prerequisities

Terdapat beberapa prerequisite yang perlu di-download untuk menginstall hadoop, diantaranya:

- [Java 8](https://www.oracle.com/id/java/technologies/javase/javase8-archive-downloads.html)
  (Recommended) / [Java 11](https://www.oracle.com/id/java/technologies/javase/jdk11-archive-downloads.html)

![DownloadPrerequisities1](/resources/Install%20Hadoop/DownloadPrerequisities1.png)

- [Hadoop](https://archive.apache.org/dist/hadoop/common/)

![DownloadPrerequisities2](/resources/Install%20Hadoop/DownloadPrerequisities2.png)

- [Additional Binaries ](https://github.com/cdarlint/winutils)(Sesuaikan versi Hadoop, binary terbaru hanya sampai v3.2.2)

![DownloadPrerequisities3](/resources/Install%20Hadoop/DownloadPrerequisities3.png)

### 2. Configure System Variables: JAVA_HOME

Tambahkan system Variable baru bernama `JAVA_HOME` dan arahkan ke instalasi Java

![JAVA_HOME](/resources/Install%20Hadoop/JAVA_HOME.png)

### 3. Configure New Path Variable

- Klik Edit

![NPV1](/resources/Install%20Hadoop/NPV1.png)

- Tambahkan Path baru ke directory Java, lalu arahkan ke folder bin di dalamnya

![NPV2](/resources/Install%20Hadoop/NPV2.png)

- Lakukan verifikasi Java JDK

![NPV3](/resources/Install%20Hadoop/NPV3.png)

### 4. Extract Hadoop targ.gz File (as Admin)

![targz1](/resources/Install%20Hadoop/targz1.png)

![targz2](/resources/Install%20Hadoop/targz2.png)

### 5. Edit `core-site.xml` `(/etc/hadoop)`

![core-site1](/resources/Install%20Hadoop/core-site1.png)

![core-site2](/resources/Install%20Hadoop/core-site2.png)

Masukkan ke dalam `core-site.xml`:

```xml
<configuration>
  <property>
    <name>fs.defaultFS</name>
    <value>hdfs://localhost:9000</value>
  </property>
</configuration>
```

### 6. Edit `mapred-site.xml` `(/etc/hadoop)`

![mapred-site](/resources/Install%20Hadoop/mapred-site.png)

Masukkan ke dalam `mapred-site.xml`:

```xml
<configuration>
  <property>
    <name>mapreduce.framework.name</name>
    <value>yarn</value>
  </property>
</configuration>
```

### 7. Edit `yarn-site.xml` `(/etc/hadoop)`

![yarn-site](/resources/Install%20Hadoop/yarn-site.png)

Masukkan ke dalam `yarn-site.xml`:

```xml
<configuration>
  <property>
    <name>yarn.nodemanager.aux-services</name>
    <value>mapreduce_shuffle</value>
  </property>
  <property>
    <name>yarn.nodemanager.mapreduce.shuffle.class</name>
    <value>org.apache.hadoop.mapred.ShuffleHandler</value>
  </property>
</configuration>
```

### 8. Create 'data' directory and Sub-Directories

![datadir1](/resources/Install%20Hadoop/datadir1.png) ➡️ ![datadir2](/resources/Install%20Hadoop/datadir2.png)

### 9. Edit `hdfs-site.xml` `(/etc/hadoop)`

![hdfs_site](/resources/Install%20Hadoop/hdfs-site.png)

Masukkan ke dalam `hdfs-site.xml` (ubah value ke path subdirectory datanode dan namenode yang telah dibuat di tahap sebelumnya):

```xml
<configuration>
  <property>
    <name>dfs.replication</name>
    <value>1</value>
  </property>
  <property>
    <name>dfs.namenode.name.dir</name>
    <value>D:\hadoop\data\namenode</value>
  </property>
  <property>
    <name>dfs.datanode.name.dir</name>
    <value>D:\hadoop\data\datanode</value>
  </property>
</configuration>
```

### 10. Edit `hadoop-env.cmd`

- Edit `hadoop-env.cmd` dengan memastikan sudah mengarah ke directory Java

![hadoop-env](/resources/Install%20Hadoop/hadoop-env.png)

### 11. Create `HADOOP_HOME` System Variable

- Buatlah System Variable baru bernama `HADOOP_HOME`

![HADOOP_HOME1](/resources/Install%20Hadoop/HADOOP_HOME1.png)

- Lalu arahkan ke directory hadoop

![HADOOP-HOME2](/resources/Install%20Hadoop/HADOOP_HOME2.png)

### 12. Create Path Variable for `/bin` and `/sbin`

![PVbin](/resources/Install%20Hadoop/PVbin.png)

### 13. Download Additional Binaries (Suit Ver.)

- Download folder dengan versi Hadoop yang sesuai. Update terakhir baru mencapai versi **3.3.2**

![PVbin](/resources/Install%20Hadoop/PVbin.png)

### 14. Move Binaries to Local `/bin`

![MoveBinaries](/resources/Install%20Hadoop/MoveBinaries.png)

### 15. Verify if Hadoop is Installed Correctly

- Lakukan verifikasi untuk mengetahui apakah Hadoop sudah terinstall secara benar dengan memberikan _command_ `hadoop version` pada _command prompt_

![VerifyHadoop](/resources/Install%20Hadoop/VerifyHadoop.png)

### 16. Format the namenode Folder

- Lakukan format untuk namenode Folder dengan cara sebagai berikut:

![FormatNameNode1](/resources/Install%20Hadoop/FormatNameNode1.png)

```cmd
hdfs namenode -format
```

Akan berakhir dengan tampilan seperti berikut:

![FormatNameNode2](/resources/Install%20Hadoop/FormatNameNode2.png)

---

## Menjalankan Hadoop dan Word Count

### Menjalankan Hadoop

Arahkan working directory ke `/hadoop/sbin` dan jika dilihat menggunakan file explorer ataupun terminal, seharusnya terlihat sebuah list file seperti di bawah
![ScriptsFolder](/resources/Run%20Hadoop/scripts.png)

Untuk menjalankan Hadoop gunakan perintah berikut

```cmd
cd /hadoop/sbin
start-all.cmd
```

Jika `start-all.cmd` sudah deprecated, jalankan satu per satu dengan cara:

```cmd
start-dfs.cmd
start-yarn.cmd
```

Untuk memberhentikan Hadoop, jalankan perintah berikut:

```cmd
stop-all.cmd
```

atau jika sudah deprecated, jalankan satu per satu:

```cmd
stop-yarn.cmd
stop-dfs.cmd
```

Command-command di atas akan menjalankan daemon Hadoop.

Untuk verifikasi Hadoop sudah berjalan, jalankan perintah:

```cmd
jps
```

Hadoop yang berjalan dengan lancar akan memiliki 4 daemon yang berjalan (ditampilkan oleh command `jps`), yaitu:

- NodeManager
- ResourceManager
- DataNode
- NameNode

Hadoop juga memiliki GUI di `localhost:9870` dan `localhost:8088` yang dapat dilihat pada kedua gambar di bawah
![GUI9870](/resources/Run%20Hadoop/gui_9870.png)
`localhost:9870` dikhususkan untuk HDFS (File system Hadoop)
![GUI8088](/resources/Run%20Hadoop/gui_8088.png)

Sedangkan `localhost:8088` dikhususkan untuk YARN (Tracking job Hadoop oleh YARN).

### Menjalankan Program Word Count dengan Hadoop MapReduce

Pertama, siapkan terlebih dahulu file text (.txt) berisikan kumpulan kata-kata yang akan dihitung frekuensinya. Masukkan file teks ke sebuah folder dalam HDFS. Untuk memasukkan file ke dalam HDFS, jalankan perintah:

```cmd
hadoop fs -mkdir /input_folder
hadoop fs -put /path/to/file.txt /input_folder
```

Perhatikan bahwa `/input_folder` adalah folder di dalam HDFS. Sesuaikan folder sesuai keinginan anda. Ubah juga path `/path/to/file.txt` ke path file teks milik anda.

Dari direktori `/code/WC with Hadoop MapReduce` yang ada di repository ini, akan ada projek Java dengan dependency Maven. Pertama, perlu melakukan build file JAR dengan perintah:

```cmd
mvn clean
mvn install
```

Setelah itu, akan ada folder `target` berisikan file `.jar` yang akan digunakan untuk menjalankan program Word Count dengan Hadoop MapReduce. Untuk menjalankan program Word Count, jalankan perintah:

```cmd
hadoop jar target/WordCount-1.0-SNAPSHOT.jar /input/input.txt /output_folder
```

Ubah parameter path sesuai dengan path file teks input dan path folder output yang diinginkan. File input dan folder output harus berada di dalam HDFS. Untuk melihat hasilnya, jalankan perintah:

```cmd
hadoop fs -cat /output_folder/part-r-00000
```

## Eksperimen Performa Hadoop MapReduce

Tujuan eksperimen ini adalah untuk menguji perbedaan waktu eksekusi program word count (Java) menggunakan Framework Hadoop MapReduce dan tanpa framework.

### Spesifikasi Hardware

| Komponen |                  Spesifikasi                   |
| :------: | :--------------------------------------------: |
|   CPU    |       AMD Ryzen 9 4900HS 3.00 GHz 8 Core       |
|   RAM    | 2x8 GB DDR4 @ 3200 MHz (1 Soldered + 1 SODIMM) |
| Storage  |    Intel SSD 660P Series 1 TB M.2 PCIE 3.0     |

### Sumber Dataset

Ada 5 variasi text file yang menjadi dataset. Berikut adalah sumber dataset yang digunakan:

- [1 MB Alcott Little](http://textfiles.com/etext/FICTION/alcott-little-261.txt)
- [10 MB (Concatenated)](http://textfiles.com/etext/FICTION/)
- [100 MB Amazon Reviews](https://www.kaggle.com/datasets/bittlingmayer/amazonreviews)
- [1 GB Gutenberg Dataset](https://www.i3s.unice.fr/~jplozi/hadooplab_lsds_2015/datasets/)
- [10 GB Wikipedia Dump](https://www.kaggle.com/datasets/toastedalmonds/wikipedia-dump-20200820)

Untuk file teks 10 MB, kami menggabungkan sejumlah file untuk membentuk satu file teks 10 MB dengan command LINUX dengan contoh sintaks sebagai berikut:

```bash
cat file1.txt file2.txt file3.txt > file10MB.txt
```

Sedangkan untuk file 10 GB, kami melakukan split terhadap file teks 17 GB menjadi 2 file teks 10 GB dengan command LINUX dengan contoh sintaks sebagai berikut:

```bash
split -l 10000000 file17GB.txt file10GB
```

### Source Code Word Count

Berikut adalah source code program word count yang digunakan:

- [Word Count dengan Hadoop MapReduce](https://hadoop.apache.org/docs/r2.7.2/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html#Example:_WordCount_v1.0)
- [Word Count tanpa Framework](/code/CountDriver.java)

### Hasil Eksperimen

Berikut adalah hasil eksperimen yang telah dilakukan:

| Dataset | Word Count dengan Hadoop MapReduce | Word Count tanpa Framework | Rasio  |
| :-----: | :--------------------------------: | :------------------------: | :----: |
|  1 MB   |                28 s                |          0.153 s           | 183.01 |
|  10 MB  |                31 s                |          0.774 s           | 40.05  |
| 100 MB  |                49 s                |          5.061 s           |  9.68  |
|  1 GB   |               107 s                |          126.28 s          |  0.85  |
|  10 GB  |               626 s                |         367.523 s          |  1.70  |

### Grafik Hasil Eksperimen

Berikut adalah grafik hasil eksperimen yang telah dilakukan:

![Grafik Hasil Eksperimen](/resources/ExperimentResultFigure.png)

## Analisis Hasil Eksperimen

Bila terlihat dari tabel dan grafik hasil eksperimen diatas, besar rasio yang dihasilkan adalah **seiring dengan bertambahnya size dataset menjadi semakin menurun secara signifikan**. Dalam hal ini, rasio yang awalnya 183.01 menjadi 40.05 dan semakin mengecil lagi hingga 0.85. Untuk memahami fenomena ini, pertama-tama perlu dipahami dulu bagaimana hadoop mapreduce bekerja.

![How Hadoop Map Reduce Works](/resources/MapReduceDiagram.png)

Dengan mengacu pada ilustrasi yang didapatkan dari [sumber](https://phoenixnap.com/kb/hadoop-mapreduce#:~:text=MapReduce%20assigns%20fragments%20of%20data,handling%20even%20petabytes%20of%20data), hadoop map reduce bekerja dengan beberapa tahap, yaitu :

1.  **Mapping**

    Dalam tahap ini, data sets akan dibagi ke dalam beberapa hadoop cluster atau node. Pada contoh diatas, data sets dibagi ke dalam 3 cluster yang masing-masing nya bekerja secara independen atau paralel sehingga tidak ada komunikasi antar cluster.

    Pada kasus ini, hadoop digunakan untuk menghitung frekuensi kemunculan huruf yang ada pada data. Maka dari itu, dibuat pasangan **<key, value>** yang menunjukkan berapa kali kata tersebut muncul pada node tersebut.

2.  **Shuffle**

    Output dari setiap node kemudian digabungkan dalam tahap ini dan di sortir sehingga terlihat total kemunculan setiap huruf pada keseluruhan node. Pada contoh ini, kata _apache_ muncul sebanyak 7 pada node pertama dan 15 pada node ketiga.

3.  **Reduce**

    Akhirnya, hasil dari tahap shuffle dikelompokkan menjadi final output yang secara default akan disimpan dalam HDFS. Pada contoh ini, total kemunculan kata _apache_ dijumlahkan dan digabungkan pada final output bersama kata-kata lainnya.

**_Bagaimana cara kerja dari hadoop map reduce berpengaruh dengan eksperimen yang sudah dilakukan?_**

Tentunya hal ini sangat berpengaruh. Sebagai contoh, pada file 1MB yang digunakan pada eksperimen diatas, data pada file tersebut harus melalui langkah-langkah dari hadoop mapreduce walaupun hanya berukuran sebesar 1MB. Akhirnya, proses dari mapreduce akan sangat _membuang waktu_ dan mengakibatkan output waktu menjadi lebih lama dibandingkan dengan tidak menggunakan map reduce.

Untuk lebih mudah dipahami, kasus ini dapat diibaratkan sebagai pengiriman paket dengan rincian: A ingin mengirimkan paket ke rumah B dari rumahnya dimana jarak dari rumah A dan rumah B hanya berjarak 1 blok. Umpamakan jarak dari kedua rumah adalah _size dari file_ yang akan diproses.

- Bila tidak menggunakan hadoop mapreduce : pengiriman paket dapat langsung dilakukan dengan mengirimkan nya secara jalan kaki dari rumah A ke rumah B.

- Bila menggunakan hadooop mapreduce : pengiriman paket harus melalui pelayanan kurir yang akan menyortir paket tersebut pada kantor kurir kemudian paket baru diantar oleh kurir ke rumah B.

Dapat terlihat bahwa tidak menggunakan kurir lebih efektif daripada menggunakan kurir.

**_Apakah penggunaan hadoop mapreduce menjadi tidak efektif sama sekali?_**

![Hadoop Explained](/resources/MapReduceDefinition.png)

Dengan mengacu pada definisi diatas yang didapatkan dari [halaman resmi hadoop](https://hadoop.apache.org/), hadoop merupakan framework yang dilakukan untuk melakukan processing **data sets yang besar**. Dengan demikian, hadoop mapreduce memang tujuannya di desain untuk melakukan hal tersebut. Hal ini disebabkan untuk file yang berukuran besar, maka untuk _task_ menghitung kata, akan lebih efektif untuk melakukan proses secara paralel dibandingkan dengan cara biasa yang memproses kata secara satu per satu. Sehingga, hadoop mapreduce memang **tidak cocok digunakan untuk file yang berukuran kecil dan ditujukan untuk file yang berukuran besar.**
