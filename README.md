# <p style="text-align: center;">Hadoop Map Reduce</p>

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

| Nama | NPM |
| :---: | :---: |
| Althaf Nafi Anwar | |
| Muhammad Suhaili | 2106731535 |
| Satya Ananda Sulistio | 2106705524 |
| Sulthan Satrya Yudha Darmawan | 2106731560 |

## Instalasi Hadoop
### 1. Download Prerequisities
Terdapat beberapa prerequisite yang perlu di-download untuk menginstall hadoop, diantaranya:
- [Java 8](https://www.oracle.com/id/java/technologies/javase/javase8-archive-downloads.html) 
 (Recommended) / [Java 11](https://www.oracle.com/id/java/technologies/javase/jdk11-archive-downloads.html)

![DownloadPrerequisities1](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/DownloadPrerequisities1.png) 

- [Hadoop](https://archive.apache.org/dist/hadoop/common/)

![DownloadPrerequisities2](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/DownloadPrerequisities2.png)

- [Additional Binaries ](https://github.com/cdarlint/winutils)(Sesuaikan versi Hadoop, binary terbaru hanya sampai v3.2.2)

![DownloadPrerequisities3](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/DownloadPrerequisities3.png)

### 2. Configure System Variables: JAVA_HOME
Tambahkan system Variable baru bernama ```JAVA_HOME``` dan arahkan ke instalasi Java

![JAVA_HOME](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/JAVA_HOME.png)

### 3. Configure New Path Variable
- Klik Edit

![NPV1](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/NPV1.png)

- Tambahkan Path baru ke directory Java, lalu arahkan ke folder bin di dalamnya

![NPV2](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/NPV2.png)

- Lakukan verifikasi Java JDK

![NPV3](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/NPV3.png)

### 4. Extract Hadoop targ.gz File (as Admin)

![targz1](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/targz1.png)

![targz2](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/targz2.png)

### 5. Edit ```core-site.xml``` ```(/etc/hadoop)```

![core-site1](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/core-site1.png)

![core-site2](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/core-site2.png)

### 6. Edit ```mapred-site.xml``` ```(/etc/hadoop)```

![mapred-site](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/mapred-site.png)

### 7. Edit ```yarn-site.xml``` ```(/etc/hadoop)```

![yarn-site](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/yarn-site.png)

### 8. Create 'data' directory and Sub-Directories

![datadir1](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/datadir1.png) ➡️ ![datadir2](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/datadir2.png)

### 9. Edit ```hdfs-site.xml``` ```(/etc/hadoop)```

### 10. Edit ```hadoop-env.cmd```
- Edit ```hadoop-env.cmd``` dengan memastikan sudah mengarah ke directory Java

![hadoop-env](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/hadoop-env.png)

### 11. Create ```HADOOP_HOME``` System Variable
- Buatlah System Variable baru bernama ```HADOOP_HOME```

![HADOOP_HOME1](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/HADOOP_HOME1.png)

- Lalu arahkan ke directory hadoop

![HADOOP-HOME2](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/HADOOP_HOME2.png)

### 12. Create Path Variable for ```/bin``` and ```/sbin```

![PVbin](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/PVbin.png)

### 13. Download Additional Binaries (Suit Ver.)
- Download folder dengan versi Hadoop yang sesuai. Update terakhir baru mencapai versi **3.3.2**

![PVbin](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/PVbin.png)

### 14. Move Binaries to Local ```/bin```

![MoveBinaries](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/MoveBinaries.png)

### 15. Verify if Hadoop is Installed Correctly
- Lakukan verifikasi untuk mengetahui apakah Hadoop sudah terinstall secara benar dengan memberikan *command* ```hadoop version``` pada *command prompt*

![VerifyHadoop](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/VerifyHadoop.png)

### 16. Format the namenode Folder
- Lakukan format untuk namenode Folder dengan cara sebagai berikut:

![FormatNameNode1](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/FormatNameNode1.png)

![FormatNameNode2](https://github.com/styxnanda/hadoop-analysis/blob/main/resources/Install%20Hadoop/FormatNameNode2.png)


## Menjalankan Hadoop dan Word Count

## Eksperimen Performa Hadoop MapReduce
Tujuan eksperimen ini adalah untuk menguji perbedaan waktu eksekusi program word count (Java) menggunakan Framework Hadoop MapReduce dan tanpa framework.

### Spesifikasi Hardware
| Komponen | Spesifikasi  |
| :---: | :---: |
| CPU | AMD Ryzen 9 4900HS 3.00 GHz 8 Core |
| RAM | 2x8 GB DDR4 @ 3200 MHz (1 Soldered + 1 SODIMM)|
| Storage | Intel SSD 660P Series 1 TB M.2 PCIE 3.0 |

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

| Dataset | Word Count dengan Hadoop MapReduce | Word Count tanpa Framework | Rasio |
| :---: | :---: | :---: | :---: |
| 1 MB | 28 s | 0.153 s | 183.01 |
| 10 MB | 31 s | 0.774 s | 40.05 |
| 100 MB | 49 s | 5.061 s | 9.68 |
| 1 GB | 107 s | 126.28 s | 0.85 |
| 10 GB | 626 s | 367.523 s | 1.70 |

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

2. **Shuffle**

    Output dari setiap node kemudian digabungkan dalam tahap ini dan di sortir sehingga terlihat total kemunculan setiap huruf pada keseluruhan node. Pada contoh ini, kata _apache_ muncul sebanyak 7 pada node pertama dan 15 pada node ketiga.

3. **Reduce**

    Akhirnya, hasil dari tahap shuffle dikelompokkan menjadi final output yang secara default akan disimpan dalam HDFS. Pada contoh ini, total kemunculan kata _apache_ dijumlahkan dan digabungkan pada final output bersama kata-kata lainnya.

***Bagaimana cara kerja dari hadoop map reduce berpengaruh dengan eksperimen yang sudah dilakukan?***

Tentunya hal ini sangat berpengaruh. Sebagai contoh, pada file 1MB yang digunakan pada eksperimen diatas, data pada file tersebut harus melalui langkah-langkah dari hadoop mapreduce walaupun hanya berukuran sebesar 1MB. Akhirnya, proses dari mapreduce akan sangat _membuang waktu_ dan mengakibatkan output waktu menjadi lebih lama dibandingkan dengan tidak menggunakan map reduce.

Untuk lebih mudah dipahami, kasus ini dapat diibaratkan sebagai pengiriman paket dengan rincian:  A ingin mengirimkan paket ke rumah B dari rumahnya dimana jarak dari rumah A dan rumah B hanya berjarak 1 blok. Umpamakan jarak dari kedua rumah adalah _size dari file_ yang akan diproses. 

- Bila tidak menggunakan hadoop mapreduce : pengiriman paket dapat langsung dilakukan dengan mengirimkan nya secara jalan kaki dari rumah A ke rumah B.

- Bila menggunakan hadooop mapreduce : pengiriman paket harus melalui pelayanan kurir yang akan menyortir paket tersebut pada kantor kurir kemudian paket baru diantar oleh kurir ke rumah B.

Dapat terlihat bahwa tidak menggunakan kurir lebih efektif daripada menggunakan kurir.

***Apakah penggunaan hadoop mapreduce menjadi tidak efektif sama sekali?***

![Hadoop Explained](/resources/MapReduceDefinition.png) 

Dengan mengacu pada definisi diatas yang didapatkan dari [halaman resmi hadoop](https://hadoop.apache.org/), hadoop merupakan framework yang dilakukan untuk melakukan processing **data sets yang besar**. Dengan demikian, hadoop mapreduce memang tujuannya di desain untuk melakukan hal tersebut. Hal ini disebabkan untuk file yang berukuran besar, maka untuk _task_ menghitung kata, akan lebih efektif untuk melakukan proses secara paralel dibandingkan dengan cara biasa yang memproses kata secara satu per satu. Sehingga, hadoop mapreduce memang **tidak cocok digunakan untuk file yang berukuran kecil dan ditujukan untuk file yang berukuran besar.**




