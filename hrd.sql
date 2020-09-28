-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2019 at 08:52 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hrd`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail`
--

CREATE TABLE `detail` (
  `kode_pegawai` varchar(10) NOT NULL,
  `nama_hw` varchar(30) DEFAULT NULL,
  `jumlah_anak` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `divisi`
--

CREATE TABLE `divisi` (
  `kode_divisi` varchar(5) NOT NULL,
  `nama_divisi` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `divisi`
--

INSERT INTO `divisi` (`kode_divisi`, `nama_divisi`) VALUES
('ADM', 'Administrasi'),
('CSH', 'Customer Service'),
('FIN', 'Keuangan'),
('HRD', 'Human Resources'),
('TRC', 'Technical Resources');

-- --------------------------------------------------------

--
-- Table structure for table `gaji`
--

CREATE TABLE `gaji` (
  `tanggal` int(2) DEFAULT NULL,
  `kode_pegawai` varchar(10) NOT NULL,
  `kode_divisi` varchar(10) DEFAULT NULL,
  `kode_tunjangan` varchar(10) DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gaji`
--

INSERT INTO `gaji` (`tanggal`, `kode_pegawai`, `kode_divisi`, `kode_tunjangan`, `total`) VALUES
(9, '32180082', 'TRC', 'T-DK', 6000000);

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `kode_jabatan` varchar(5) NOT NULL,
  `nama_jabatan` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`kode_jabatan`, `nama_jabatan`) VALUES
('AKT', 'Akuntan'),
('DIR', 'Direktur'),
('ITS', 'IT Support'),
('MNJ', 'Manajer'),
('PRS', 'Personalia'),
('SPV', 'Supervisor');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `kode_pegawai` varchar(10) NOT NULL,
  `nama` varchar(25) DEFAULT NULL,
  `kode_jabatan` varchar(15) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `jenis_kelamin` varchar(25) DEFAULT NULL,
  `tgl_masuk` date DEFAULT NULL,
  `status` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`kode_pegawai`, `nama`, `kode_jabatan`, `tgl_lahir`, `jenis_kelamin`, `tgl_masuk`, `status`) VALUES
('32180018', 'Ferdy Nicolas', 'MNJ', '2000-10-18', 'Pria', '2019-05-14', 'Belum Menikah'),
('32180075', 'Willy Susilo', 'ITS', '2019-05-01', 'Pria', '2019-05-04', 'Menikah'),
('32180082', 'Jason Alexander', 'PRS', '2000-11-14', 'Pria', '2019-05-01', 'Belum Menikah'),
('32180086', 'Derry Leo Nardi', 'ITS', '2000-06-18', 'Pria', '2019-05-03', 'Belum Menikah'),
('32180088', 'Jayaku Briliantio', 'DIR', '2019-05-02', 'Pria', '2019-05-11', 'Menikah');

-- --------------------------------------------------------

--
-- Table structure for table `pengangkatan`
--

CREATE TABLE `pengangkatan` (
  `kode_karyawan` varchar(10) NOT NULL,
  `kode_divisi` varchar(5) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `nomor_sk` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengangkatan`
--

INSERT INTO `pengangkatan` (`kode_karyawan`, `kode_divisi`, `tanggal`, `nomor_sk`) VALUES
('32180082', 'TRC', '2019-05-02', 'SK001'),
('32180099', 'C++', '2019-05-19', 'IDIOTS99');

-- --------------------------------------------------------

--
-- Table structure for table `posisi`
--

CREATE TABLE `posisi` (
  `kode_pegawai` varchar(10) NOT NULL,
  `kode_jabatan` varchar(10) DEFAULT NULL,
  `tgl_mulai` date DEFAULT NULL,
  `tgl_selesai` date DEFAULT NULL,
  `periode` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `posisi`
--

INSERT INTO `posisi` (`kode_pegawai`, `kode_jabatan`, `tgl_mulai`, `tgl_selesai`, `periode`) VALUES
('32180018', 'DIR', '2019-05-09', '2019-05-10', 2),
('32180075', 'ITS', '2019-05-01', '2019-05-19', 1),
('32180082', 'PRS', '2019-05-01', '2019-05-31', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tunjangan`
--

CREATE TABLE `tunjangan` (
  `kode_tunjangan` varchar(5) NOT NULL,
  `nama_tunjangan` varchar(25) DEFAULT NULL,
  `nilai` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tunjangan`
--

INSERT INTO `tunjangan` (`kode_tunjangan`, `nama_tunjangan`, `nilai`) VALUES
('T-A1', 'Tunjangan 1 Anak', 1000000),
('T-A2', 'Tunjangan 2 Anak', 2000000),
('T-DK', 'Tunjangan Disabilitas', 3500000),
('T-HL', 'Tunjangan Masa Tua', 2500000),
('T-LX', 'Tunjangan Lembur', 500000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail`
--
ALTER TABLE `detail`
  ADD PRIMARY KEY (`kode_pegawai`);

--
-- Indexes for table `divisi`
--
ALTER TABLE `divisi`
  ADD PRIMARY KEY (`kode_divisi`);

--
-- Indexes for table `gaji`
--
ALTER TABLE `gaji`
  ADD PRIMARY KEY (`kode_pegawai`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`kode_jabatan`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`kode_pegawai`);

--
-- Indexes for table `pengangkatan`
--
ALTER TABLE `pengangkatan`
  ADD PRIMARY KEY (`kode_karyawan`);

--
-- Indexes for table `posisi`
--
ALTER TABLE `posisi`
  ADD PRIMARY KEY (`kode_pegawai`);

--
-- Indexes for table `tunjangan`
--
ALTER TABLE `tunjangan`
  ADD PRIMARY KEY (`kode_tunjangan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
