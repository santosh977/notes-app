-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 17, 2014 at 05:02 PM
-- Server version: 5.1.37
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


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
  `f_mail` varchar(100) NOT NULL,
  `f_message` varchar(100) NOT NULL,
  `f_status` tinyint(4) NOT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `feedbacks`
--

INSERT INTO `feedbacks` (`f_id`, `f_mail`, `f_message`, `f_status`) VALUES
(1, 'ruby_737@yahoo.co.in', '	nice website	  		  ', 1);

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
  `college_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `study_college`
--

INSERT INTO `study_college` (`college_id`, `college_name`, `college_city_id`, `college_state_id`, `college_country_id`, `college_status`) VALUES
(1, 'lachoo', 1, 1, 1, 0),
(3, 'gyan vihar', 1, 1, 2, 0);

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

--
-- Dumping data for table `study_college_courses`
--


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

--
-- Dumping data for table `study_comments`
--


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
(1, 'engineering', 1),
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

--
-- Dumping data for table `study_error`
--


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

--
-- Dumping data for table `study_likes`
--


-- --------------------------------------------------------

--
-- Table structure for table `study_material`
--

CREATE TABLE IF NOT EXISTS `study_material` (
  `sm_id` int(11) NOT NULL AUTO_INCREMENT,
  `sm_userid` int(11) NOT NULL,
  `sm_type` varchar(100) NOT NULL,
  `sm_file` varchar(100) NOT NULL,
  `sm_category` varchar(100) NOT NULL,
  `sm_course_id` int(11) NOT NULL,
  `sm_branch_id` int(11) NOT NULL,
  `sm_year_id` int(11) NOT NULL,
  `sm_semester_id` int(11) NOT NULL,
  `sm_subject_id` int(11) NOT NULL,
  `sm_status` tinyint(4) NOT NULL,
  `sm_datetime` datetime NOT NULL,
  PRIMARY KEY (`sm_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `study_material`
--

INSERT INTO `study_material` (`sm_id`, `sm_userid`, `sm_type`, `sm_file`, `sm_category`, `sm_course_id`, `sm_branch_id`, `sm_year_id`, `sm_semester_id`, `sm_subject_id`, `sm_status`, `sm_datetime`) VALUES
(1, 0, 'pdf', '', '', 1, 2, 3, 1, 0, 0, '0000-00-00 00:00:00'),
(12, 0, 'jpg', '6701051rock.jpg', 'notes', 0, 0, 0, 0, 0, 0, '2014-07-17 16:30:05');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `study_state`
--

INSERT INTO `study_state` (`state_id`, `state_country_id`, `state_name`, `state_status`) VALUES
(1, 1, 'rajasthan', 1),
(2, 1, 'uttar pradesh', 1);

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `study_team_members`
--


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

--
-- Dumping data for table `study_team_type`
--


-- --------------------------------------------------------

--
-- Table structure for table `study_users`
--

CREATE TABLE IF NOT EXISTS `study_users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `user_email_id` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_pic` varchar(200) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `study_users`
--


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
