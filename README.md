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
| Muhammad Suhaili | |
| Satya Ananda Sulistio | 2106705524 |
| Sulthan Satrya Y. D. | |

## Instalasi Hadoop

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