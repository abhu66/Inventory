-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 06 Agu 2017 pada 21.08
-- Versi Server: 10.1.19-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `brand`
--

CREATE TABLE `brand` (
  `id_brand` int(3) UNSIGNED ZEROFILL NOT NULL,
  `nama_brand` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `brand`
--

INSERT INTO `brand` (`id_brand`, `nama_brand`) VALUES
(001, 'ZARA'),
(002, 'FAKE LONDON'),
(003, 'RSCH');

-- --------------------------------------------------------

--
-- Struktur dari tabel `history_login_user`
--

CREATE TABLE `history_login_user` (
  `user_name` varchar(20) DEFAULT NULL,
  `user_password` varchar(30) DEFAULT NULL,
  `user_password_md5` varchar(60) DEFAULT NULL,
  `user_hak` enum('admin','petugas') DEFAULT NULL,
  `aksi` varchar(10) DEFAULT NULL,
  `aksi_tanggal` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `history_login_user`
--

INSERT INTO `history_login_user` (`user_name`, `user_password`, `user_password_md5`, `user_hak`, `aksi`, `aksi_tanggal`) VALUES
('USER', 'asu66', '0f2198bdab38c936a7e9f9bbb3e5c93f', 'petugas', 'UPDATE', '2017-04-21 00:00:00'),
('ADMIN1', 'abhu77', '998b9897382cf28993d849dcdf46b999', 'admin', 'UPDATE', '2017-04-21 00:00:00'),
('ADMIN1', 'abhu66', '5ce08b8f9edb03bdb6ac670fd94a7e91', 'admin', 'UPDATE', '2017-04-22 00:00:00'),
('USER2', 'user2', '7e58d63b60197ceb55a1c487989a3720', 'petugas', 'INSERT', '2017-04-22 00:00:00'),
('USER2', 'user22', '87dc1e131a1369fdf8f1c824a6a62dff', 'petugas', 'UPDATE', '2017-04-22 00:00:00'),
('USER2', 'user22', '87dc1e131a1369fdf8f1c824a6a62dff', 'petugas', 'DELETE', '2017-04-23 00:00:00'),
('USER', 'asu66', '0f2198bdab38c936a7e9f9bbb3e5c93f', 'petugas', 'DELETE', '2017-04-23 00:00:00'),
('ANGGA', 'angga66', '97f5bbe5cadf93261850565070456cc4', 'petugas', 'INSERT', '2017-04-23 10:38:49'),
('FIKRI', 'fikri53', '419d19c1bdf72911c34a1a7e438a69a6', 'petugas', 'INSERT', '2017-04-23 11:17:03'),
('ANGGA', 'angga53', 'cffc8536341a1e4b9a7ca4341797bbc6', 'petugas', 'UPDATE', '2017-04-23 11:19:19'),
('FIKRI', 'fikri53', '419d19c1bdf72911c34a1a7e438a69a6', 'petugas', 'DELETE', '2017-04-23 13:58:03'),
('ANGGA', 'angga53', 'cffc8536341a1e4b9a7ca4341797bbc6', 'petugas', 'DELETE', '2017-04-24 17:34:49'),
('ARKY', 'arki66', '6f0ba740c7e1e9d134b5647554c6985a', 'petugas', 'INSERT', '2017-04-24 20:50:29'),
('PRINDA', 'prinda66', '1e34131d5d49638b683bb2d54420d9d4', 'petugas', 'INSERT', '2017-04-26 20:41:23'),
('REZA', 'reza66', '6e7beabba983e890240af10bbb3a18f1', 'petugas', 'INSERT', '2017-04-27 20:49:55');

-- --------------------------------------------------------

--
-- Struktur dari tabel `item`
--

CREATE TABLE `item` (
  `id_item` char(13) NOT NULL,
  `nama_item` varchar(50) NOT NULL,
  `nomor_pembelian` int(6) UNSIGNED ZEROFILL NOT NULL,
  `tanggal_beli` date NOT NULL,
  `id_brand` int(3) UNSIGNED ZEROFILL NOT NULL,
  `id_warna` int(3) NOT NULL,
  `harga_item` decimal(10,0) NOT NULL,
  `id_toko` varchar(6) NOT NULL,
  `jumlah_item` int(2) NOT NULL,
  `status` enum('AVL','NVL') NOT NULL,
  `tanggal_input` date NOT NULL,
  `petugas` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `item`
--

INSERT INTO `item` (`id_item`, `nama_item`, `nomor_pembelian`, `tanggal_beli`, `id_brand`, `id_warna`, `harga_item`, `id_toko`, `jumlah_item`, `status`, `tanggal_input`, `petugas`) VALUES
('I000001', 'celana', 000001, '2017-04-23', 001, 1, '250000', 'T001', 1, 'AVL', '2017-04-23', 'ADMIN1'),
('I000002', 'baju', 000002, '2017-04-23', 002, 3, '340000', 'T006', 1, 'AVL', '2017-04-23', 'ADMIN1'),
('I000003', 'rok', 000002, '2017-04-23', 001, 1, '150000', 'T001', 1, 'AVL', '2017-04-23', 'ADMIN1'),
('I000004', 'celana', 000003, '2017-04-24', 001, 3, '300000', 'T001', 1, 'AVL', '2017-04-24', 'ADMIN1'),
('I000005', 'baju', 000003, '2017-04-24', 002, 2, '350000', 'T006', 1, 'AVL', '2017-04-24', 'ADMIN1'),
('I000006', 'baju', 000004, '2017-05-09', 001, 1, '290000', 'T001', 1, 'AVL', '2017-05-09', 'ADMIN1'),
('I000007', 'celana', 000004, '2017-05-09', 002, 4, '250000', 'T006', 1, 'AVL', '2017-05-09', 'ADMIN1'),
('I000008', 'dddd', 000006, '2017-06-23', 001, 1, '270000', 'T001', 1, 'AVL', '2017-06-23', 'ADMIN1'),
('I000009', 'adasa', 000006, '2017-06-23', 002, 3, '410000', 'T006', 1, 'AVL', '2017-06-23', 'ADMIN1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `link_item_brand`
--

CREATE TABLE `link_item_brand` (
  `id_item` char(13) NOT NULL,
  `id_brand` int(3) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `link_item_brand`
--

INSERT INTO `link_item_brand` (`id_item`, `id_brand`) VALUES
('I000001', 001),
('I000002', 002),
('I000003', 001),
('I000004', 001),
('I000005', 002),
('I000006', 001),
('I000007', 002),
('I000008', 001),
('I000009', 002);

-- --------------------------------------------------------

--
-- Struktur dari tabel `link_item_toko`
--

CREATE TABLE `link_item_toko` (
  `id_item` char(13) NOT NULL,
  `id_toko` char(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `link_item_toko`
--

INSERT INTO `link_item_toko` (`id_item`, `id_toko`) VALUES
('I000001', 'T001'),
('I000002', 'T006'),
('I000003', 'T001'),
('I000004', 'T001'),
('I000005', 'T006'),
('I000006', 'T001'),
('I000007', 'T006'),
('I000008', 'T001'),
('I000009', 'T006');

-- --------------------------------------------------------

--
-- Struktur dari tabel `link_item_warna`
--

CREATE TABLE `link_item_warna` (
  `id_item` char(13) NOT NULL,
  `id_warna` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `link_item_warna`
--

INSERT INTO `link_item_warna` (`id_item`, `id_warna`) VALUES
('I000001', 1),
('I000002', 3),
('I000003', 1),
('I000004', 3),
('I000005', 2),
('I000006', 1),
('I000007', 4),
('I000008', 1),
('I000009', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `login_user`
--

CREATE TABLE `login_user` (
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(30) NOT NULL,
  `user_password_md5` varchar(60) NOT NULL,
  `user_hak` enum('admin','petugas') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login_user`
--

INSERT INTO `login_user` (`user_name`, `user_password`, `user_password_md5`, `user_hak`) VALUES
('ADMIN1', 'abhu66', '5ce08b8f9edb03bdb6ac670fd94a7e91', 'admin'),
('ARKY', 'arki66', '6f0ba740c7e1e9d134b5647554c6985a', 'petugas'),
('PRINDA', 'prinda66', '1e34131d5d49638b683bb2d54420d9d4', 'petugas'),
('REZA', 'reza66', '6e7beabba983e890240af10bbb3a18f1', 'petugas');

--
-- Trigger `login_user`
--
DELIMITER $$
CREATE TRIGGER `tr_ad_user` AFTER DELETE ON `login_user` FOR EACH ROW BEGIN
		INSERT INTO history_login_user values (
		OLD.user_name,
		OLD.user_password,
		OLD.user_password_md5,
		OLD.user_hak,
		'DELETE',
		NOW()
	        );
        END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tr_ai_user` AFTER INSERT ON `login_user` FOR EACH ROW BEGIN
	INSERT INTO history_login_user values(
	NEW.user_name,
	NEW.user_password,
	NEW.user_password_md5,
	NEW.user_hak,
	'INSERT',
	NOW()
);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tr_au_user` AFTER UPDATE ON `login_user` FOR EACH ROW BEGIN
	DECLARE username varchar(20);
	DECLARE userpassword varchar(30);
	DECLARE userpasswordmd5 varchar(60);
	DECLARE userhak enum("admin","petugas");
	
		IF NEW.user_name is NULL THEN
			SET username = OLD.user_name;
		ELSE
			SET username = NEW.user_name;
		END IF;
		
		IF NEW.user_password is NULL THEN
			SET userpassword = OLD.user_password;
		ELSE
			SET userpassword = NEW.user_password;
		END IF;
		
		IF NEW.user_password_md5 is NULL THEN
			SET userpasswordmd5 = OLD.user_password_md5;
		ELSE
			SET userpasswordmd5 = NEW.user_password_md5;
		END IF;
		
		IF NEW.user_hak is NULL THEN
			SET userhak = OLD.user_hak;
		ELSE
			SET userhak = NEW.user_hak;
		END IF;

	INSERT INTO history_login_user VALUES(
		username,
		userpassword,
		userpasswordmd5,
		userhak,
		'UPDATE',
		NOW()
);

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembelian`
--

CREATE TABLE `pembelian` (
  `nomor_pembelian` int(6) UNSIGNED ZEROFILL NOT NULL,
  `nama_pembeli` varchar(50) NOT NULL,
  `tanggal_beli` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pembelian`
--

INSERT INTO `pembelian` (`nomor_pembelian`, `nama_pembeli`, `tanggal_beli`) VALUES
(000001, 'Item 1', '2017-04-23'),
(000002, 'Item 1', '2017-04-23'),
(000003, 'Item 1', '2017-04-24'),
(000004, 'Item 1', '2017-05-09'),
(000005, 'Item 1', '2017-05-16'),
(000006, 'Item 1', '2017-06-23');

-- --------------------------------------------------------

--
-- Struktur dari tabel `toko`
--

CREATE TABLE `toko` (
  `id_toko` char(4) NOT NULL,
  `nama_toko` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `telpon` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `toko`
--

INSERT INTO `toko` (`id_toko`, `nama_toko`, `alamat`, `telpon`) VALUES
('T001', 'ZARA', 'MALL CENTRAL PARK JAKARTA BARAT', '02154377375'),
('T002', 'STRADIVARIUS', 'MALL CENTRAL PARK JAKARTA BARAT', '0214377375'),
('T003', 'PULL & BEAR', 'MALL KOKAS JAKARTA SEATAN', '08091923121'),
('T004', 'H&M', 'MALL GANDARIA CITY JAKARTA', '08080021333'),
('T005', 'MANGO', 'MALL CENTRAL PARK', '0808203121'),
('T006', 'FAKE LONDON', 'MALL TAMAN ANGGREK JAKARTA', '0212344321'),
('T007', 'RSCH', 'TEBET DALAM', '2212121'),
('T008', 'ZARA', 'KEMANG VILLAGE', '02165636178'),
('T009', 'H&M', 'MALL KOTA KASABLANKA', '08080894545');

-- --------------------------------------------------------

--
-- Struktur dari tabel `warna`
--

CREATE TABLE `warna` (
  `id_warna` int(3) NOT NULL,
  `nama_warna` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `warna`
--

INSERT INTO `warna` (`id_warna`, `nama_warna`) VALUES
(1, 'MERAH'),
(2, 'HITAM'),
(3, 'PUTIH'),
(4, 'BIRU NAVY');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id_brand`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id_item`),
  ADD KEY `nomor_pembelian` (`nomor_pembelian`);

--
-- Indexes for table `link_item_brand`
--
ALTER TABLE `link_item_brand`
  ADD PRIMARY KEY (`id_item`,`id_brand`),
  ADD KEY `id_brand` (`id_brand`);

--
-- Indexes for table `link_item_toko`
--
ALTER TABLE `link_item_toko`
  ADD PRIMARY KEY (`id_item`,`id_toko`),
  ADD KEY `id_toko` (`id_toko`);

--
-- Indexes for table `link_item_warna`
--
ALTER TABLE `link_item_warna`
  ADD PRIMARY KEY (`id_item`,`id_warna`),
  ADD KEY `id_warna` (`id_warna`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`nomor_pembelian`);

--
-- Indexes for table `toko`
--
ALTER TABLE `toko`
  ADD PRIMARY KEY (`id_toko`);

--
-- Indexes for table `warna`
--
ALTER TABLE `warna`
  ADD PRIMARY KEY (`id_warna`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `id_brand` int(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `warna`
--
ALTER TABLE `warna`
  MODIFY `id_warna` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`nomor_pembelian`) REFERENCES `pembelian` (`nomor_pembelian`);

--
-- Ketidakleluasaan untuk tabel `link_item_brand`
--
ALTER TABLE `link_item_brand`
  ADD CONSTRAINT `link_item_brand_ibfk_1` FOREIGN KEY (`id_item`) REFERENCES `item` (`id_item`),
  ADD CONSTRAINT `link_item_brand_ibfk_2` FOREIGN KEY (`id_brand`) REFERENCES `brand` (`id_brand`);

--
-- Ketidakleluasaan untuk tabel `link_item_toko`
--
ALTER TABLE `link_item_toko`
  ADD CONSTRAINT `link_item_toko_ibfk_1` FOREIGN KEY (`id_item`) REFERENCES `item` (`id_item`),
  ADD CONSTRAINT `link_item_toko_ibfk_2` FOREIGN KEY (`id_toko`) REFERENCES `toko` (`id_toko`);

--
-- Ketidakleluasaan untuk tabel `link_item_warna`
--
ALTER TABLE `link_item_warna`
  ADD CONSTRAINT `link_item_warna_ibfk_1` FOREIGN KEY (`id_item`) REFERENCES `item` (`id_item`),
  ADD CONSTRAINT `link_item_warna_ibfk_2` FOREIGN KEY (`id_warna`) REFERENCES `warna` (`id_warna`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
