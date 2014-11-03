-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 06, 2014 at 01:15 PM
-- Server version: 5.6.14
-- PHP Version: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `study`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(100) NOT NULL,
  `admin_password` varchar(100) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_name`, `admin_password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `feedbacks`
--

CREATE TABLE IF NOT EXISTS `feedbacks` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(100) NOT NULL,
  `f_mail` varchar(100) NOT NULL,
  `f_message` varchar(100) NOT NULL,
  `f_status` tinyint(4) NOT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `feedbacks`
--

INSERT INTO `feedbacks` (`f_id`, `f_name`, `f_mail`, `f_message`, `f_status`) VALUES
(1, 'deepali', 'ruby_737@yahoo.co.in', '	nice website	  		  ', 1),
(2, 'iip', 'info@iipacademy.com', 'gud one', 0);

-- --------------------------------------------------------

--
-- Table structure for table `study_branches`
--

CREATE TABLE IF NOT EXISTS `study_branches` (
  `branch_id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_name` varchar(100) NOT NULL,
  `branch_course_id` int(11) NOT NULL,
  `branch_status` int(11) NOT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `study_branches`
--

INSERT INTO `study_branches` (`branch_id`, `branch_name`, `branch_course_id`, `branch_status`) VALUES
(1, 'computer science', 1, 1),
(2, 'electronics', 1, 1),
(3, 'finance', 3, 1),
(4, 'hr', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `study_category`
--

CREATE TABLE IF NOT EXISTS `study_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `category_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `study_category`
--

INSERT INTO `study_category` (`category_id`, `category_name`, `category_status`) VALUES
(3, 'notes', 1),
(5, 'assignments', 1),
(6, 'questionpaper', 1),
(7, 'quiz', 1);

-- --------------------------------------------------------

--
-- Table structure for table `study_city`
--

CREATE TABLE IF NOT EXISTS `study_city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(100) NOT NULL,
  `city_state_id` int(11) NOT NULL,
  `city_status` tinyint(4) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `study_city`
--

INSERT INTO `study_city` (`city_id`, `city_name`, `city_state_id`, `city_status`) VALUES
(1, 'jodhpur', 1, 1),
(2, 'jaipur', 1, 1),
(3, 'Agra(U.P)', 2, 1),
(4, 'lucknow', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `study_college`
--

CREATE TABLE IF NOT EXISTS `study_college` (
  `college_id` int(11) NOT NULL AUTO_INCREMENT,
  `college_name` varchar(255) NOT NULL,
  `college_city_id` int(11) NOT NULL,
  `college_state_id` int(11) NOT NULL,
  `college_country_id` int(11) NOT NULL,
  `college_course` varchar(255) NOT NULL,
  `college_logo` varchar(255) NOT NULL,
  `college_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `study_college`
--

INSERT INTO `study_college` (`college_id`, `college_name`, `college_city_id`, `college_state_id`, `college_country_id`, `college_course`, `college_logo`, `college_status`) VALUES
(26, 'slbs', 1, 0, 1, '1,3', '899logo3.jpg', 0),
(27, 'Lachoo', 1, 0, 1, '1,2,3', '196logo1.jpg', 0),
(28, 'lucky', 1, 0, 1, '2,3', '497logo2.jpg', 0),
(29, 'savitri phule', 1, 0, 1, '1', '244logo4.jpg', 0),
(30, 'Gyan vihar', 2, 0, 1, '1', '607logo6.png', 0);

-- --------------------------------------------------------

--
-- Table structure for table `study_college_courses`
--

CREATE TABLE IF NOT EXISTS `study_college_courses` (
  `scc_id` int(11) NOT NULL AUTO_INCREMENT,
  `scc_college_id` int(11) NOT NULL,
  `scc_course_id` int(11) NOT NULL,
  `scc_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`scc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `study_comments`
--

CREATE TABLE IF NOT EXISTS `study_comments` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_user_id` int(11) NOT NULL,
  `comment_sm_id` int(11) NOT NULL,
  `comment_rating` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `study_country`
--

CREATE TABLE IF NOT EXISTS `study_country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(100) NOT NULL,
  `country_status` int(11) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `study_country`
--

INSERT INTO `study_country` (`country_id`, `country_name`, `country_status`) VALUES
(1, 'india', 1);

-- --------------------------------------------------------

--
-- Table structure for table `study_courses`
--

CREATE TABLE IF NOT EXISTS `study_courses` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) NOT NULL,
  `course_status` int(11) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `study_courses`
--

INSERT INTO `study_courses` (`course_id`, `course_name`, `course_status`) VALUES
(1, 'Engineering', 1),
(2, 'medical', 1),
(3, 'Mba', 1);

-- --------------------------------------------------------

--
-- Table structure for table `study_error`
--

CREATE TABLE IF NOT EXISTS `study_error` (
  `se_id` int(11) NOT NULL,
  `se_path` varchar(100) NOT NULL,
  `se_error_type` enum('p','l') NOT NULL,
  `se_link` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `study_likes`
--

CREATE TABLE IF NOT EXISTS `study_likes` (
  `like_id` int(11) NOT NULL AUTO_INCREMENT,
  `like_user_id` int(11) NOT NULL,
  `like_count` int(11) NOT NULL,
  `like_sm_id` int(11) NOT NULL,
  PRIMARY KEY (`like_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `study_material`
--

CREATE TABLE IF NOT EXISTS `study_material` (
  `sm_id` int(11) NOT NULL AUTO_INCREMENT,
  `sm_userid` int(11) NOT NULL,
  `sm_type` varchar(100) NOT NULL,
  `sm_file` varchar(100) NOT NULL,
  `sm_countryid` int(11) NOT NULL,
  `sm_stateid` int(11) NOT NULL,
  `sm_cityid` int(11) NOT NULL,
  `sm_collegeid` int(11) NOT NULL,
  `sm_filetopic` varchar(255) NOT NULL,
  `sm_category` varchar(100) NOT NULL,
  `sm_course_id` int(11) NOT NULL,
  `sm_branch_id` int(11) NOT NULL,
  `sm_year_id` int(11) NOT NULL,
  `sm_semester_id` int(11) NOT NULL,
  `sm_subject_id` int(11) NOT NULL,
  `sm_status` tinyint(4) NOT NULL,
  `sm_datetime` datetime NOT NULL,
  PRIMARY KEY (`sm_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `study_material`
--

INSERT INTO `study_material` (`sm_id`, `sm_userid`, `sm_type`, `sm_file`, `sm_countryid`, `sm_stateid`, `sm_cityid`, `sm_collegeid`, `sm_filetopic`, `sm_category`, `sm_course_id`, `sm_branch_id`, `sm_year_id`, `sm_semester_id`, `sm_subject_id`, `sm_status`, `sm_datetime`) VALUES
(3, 8, 'pdf', 'CakePHPCookbook.pdf', 0, 0, 0, 26, 'cakephp', 'notes', 1, 1, 2, 1, 1, 0, '0000-00-00 00:00:00'),
(4, 8, 'pdf', 'lec1.pdf', 0, 0, 0, 27, 'enginnering lecture', 'assignment', 1, 3, 1, 1, 1, 0, '0000-00-00 00:00:00'),
(5, 9, '', '220948Insurance.pptx', 1, 0, 1, 0, 'test', 'assignment', 1, 1, 1, 1, 1, 0, '0000-00-00 00:00:00'),
(6, 9, '', '875001deepali asimo presentation.docx', 1, 0, 1, 0, 'test1', 'assignment', 1, 1, 1, 1, 1, 0, '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `study_semester`
--

CREATE TABLE IF NOT EXISTS `study_semester` (
  `semester_id` int(11) NOT NULL AUTO_INCREMENT,
  `semester_name` varchar(100) NOT NULL,
  `semester_course_id` int(11) NOT NULL,
  `semester_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`semester_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `study_semester`
--

INSERT INTO `study_semester` (`semester_id`, `semester_name`, `semester_course_id`, `semester_status`) VALUES
(1, '1st', 1, 1),
(2, '2nd', 1, 1),
(3, '4th', 3, 1),
(4, '5th', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `study_state`
--

CREATE TABLE IF NOT EXISTS `study_state` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `state_country_id` int(11) NOT NULL,
  `state_name` varchar(100) NOT NULL,
  `state_status` int(11) NOT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `study_state`
--

INSERT INTO `study_state` (`state_id`, `state_country_id`, `state_name`, `state_status`) VALUES
(1, 1, 'rajasthan', 1),
(2, 1, 'uttar pradesh', 1),
(3, 1, 'goa', 1);

-- --------------------------------------------------------

--
-- Table structure for table `study_subject`
--

CREATE TABLE IF NOT EXISTS `study_subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_college_id` int(11) NOT NULL,
  `subject_course_id` int(11) NOT NULL,
  `subject_branch_id` int(11) NOT NULL,
  `subject_year_id` int(11) NOT NULL,
  `subject_semester_id` int(11) NOT NULL,
  `subject_name` varchar(255) NOT NULL,
  `subject_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `study_subject`
--

INSERT INTO `study_subject` (`subject_id`, `subject_college_id`, `subject_course_id`, `subject_branch_id`, `subject_year_id`, `subject_semester_id`, `subject_name`, `subject_status`) VALUES
(1, 1, 3, 3, 2, 3, 'accounts', 0);

-- --------------------------------------------------------

--
-- Table structure for table `study_team_members`
--

CREATE TABLE IF NOT EXISTS `study_team_members` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_type` int(11) NOT NULL,
  `team_country` int(11) NOT NULL,
  `team_state` int(11) NOT NULL,
  `team_city` int(11) NOT NULL,
  `team_college_id` int(11) NOT NULL,
  `team_member_name` varchar(100) NOT NULL,
  `team_member_photo` varchar(100) NOT NULL,
  `team_status` tinyint(4) NOT NULL,
  `team_member_link` varchar(100) NOT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `study_team_members`
--

INSERT INTO `study_team_members` (`team_id`, `team_type`, `team_country`, `team_state`, `team_city`, `team_college_id`, `team_member_name`, `team_member_photo`, `team_status`, `team_member_link`) VALUES
(1, 0, 1, 1, 1, 18, 'abc', '552classic_women20.jpg', 1, ''),
(2, 0, 1, 2, 3, 21, 'deep1', '857sweet-baby-girl-cutebabiesphoto.blogspot.com.jpg (8).jpg', 1, ''),
(3, 0, 1, 1, 2, 20, 'new', '230baby-girl2.jpg', 1, ''),
(4, 0, 1, 1, 1, 19, 'deepali', '928Lace-Dresses-8.jpg', 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `study_team_type`
--

CREATE TABLE IF NOT EXISTS `study_team_type` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_type` varchar(100) NOT NULL,
  `team_type_status` tinyint(4) NOT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `study_users`
--

CREATE TABLE IF NOT EXISTS `study_users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `user_email_id` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_profile_pic` varchar(200) NOT NULL,
  `user_country` text NOT NULL,
  `user_semester` text NOT NULL,
  `user_state` varchar(100) NOT NULL,
  `user_city` varchar(100) NOT NULL,
  `user_college` varchar(100) NOT NULL,
  `user_mobile_no` varchar(100) NOT NULL,
  `user_course` varchar(100) NOT NULL,
  `user_branch` varchar(100) NOT NULL,
  `user_year` year(4) NOT NULL,
  `user_address` text NOT NULL,
  `user_pin` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `study_users`
--

INSERT INTO `study_users` (`user_id`, `user_name`, `user_email_id`, `user_password`, `user_profile_pic`, `user_country`, `user_semester`, `user_state`, `user_city`, `user_college`, `user_mobile_no`, `user_course`, `user_branch`, `user_year`, `user_address`, `user_pin`) VALUES
(6, 'ruby', 'ruby.yadav@aol.com', 'hello', '147645562842_403889059674458_803138584_n.jpg', '1', '', '2', '2', 'lachoo', '323232', 'engineering', 'finance', 2001, '', 0),
(7, 'ritu yadav', 'ritu@gmail.com', '123', '892609IMG-20130805-WA0001.jpg', '1', '', '1', '1', '6', '323232', '1', '2', 2002, '', 0),
(8, 'deepali', 'deepalihemrajani590@gmail.com', 'hello', '920624IMAG1475.jpg', '1', '', '1', '1', '1', '323232', '1', '5', 2002, '', 0),
(13, 'ruby   ', 'ruby123@yahoo.com', '123', '487397Lace-Dresses-8.jpg', '', '3', '', '', '26', '9256453232323', '3', '3', 2003, '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `study_year`
--

CREATE TABLE IF NOT EXISTS `study_year` (
  `year_id` int(11) NOT NULL AUTO_INCREMENT,
  `year_name` varchar(100) NOT NULL,
  `year_course_id` int(11) NOT NULL,
  `year_status` tinyint(4) NOT NULL,
  PRIMARY KEY (`year_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `study_year`
--

INSERT INTO `study_year` (`year_id`, `year_name`, `year_course_id`, `year_status`) VALUES
(1, 'first', 1, 1),
(2, 'second', 1, 1),
(3, 'first', 3, 1),
(4, 'third', 1, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
