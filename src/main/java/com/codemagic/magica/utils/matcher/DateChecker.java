/**
 * 
 */
package com.codemagic.magica.utils.matcher;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Checks for the presence of valid date.
 * 
 * The delimiters accepted as of this version are '-', '/' and ' '.
 * 
 * @author Nataraj Gnanavadivel
 *
 */
public class DateChecker {
   // 31-12-2015 (Commonly Used)
   private static final Pattern PATTERN_DD_MM_YYYY      = Pattern.compile(
                                                                          "(\\b((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\\-| )((0?[1-9])|(1[0-2]))(/|\\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\\b)");
   // 31-DEC-2015 (Commonly Used)
   private static final Pattern PATTERN_DD_MMM_YYYY     = Pattern.compile(
                                                                          "(\\b((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\\b)");
   // 31-December-2015 (Commonly Used)
   private static final Pattern PATTERN_DD_MONTH_YYYY   = Pattern.compile(
                                                                          "(\\b((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\\b)");
   // 31st DEC 2015 (Commonly Used)
   private static final Pattern PATTERN_DDSS_MMM_YYYY   = Pattern.compile(
                                                                          "(\\b((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\\b)");
   // 31st December 2015 (Commonly Used)
   private static final Pattern PATTERN_DDSS_MONTH_YYYY = Pattern.compile(
                                                                          "(\\b((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\\b)");

   // 12-31-2015 (Commonly Used)
   private static final Pattern PATTERN_MM_DD_YYYY      = Pattern.compile(
                                                                          "(\\b((0?[1-9])|(1[0-2]))(/|\\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\\b)");
   // DEC 31 2015 (Rare)
   private static final Pattern PATTERN_MMM_DD_YYYY     = Pattern.compile(
                                                                          "(\\b((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\\b)");
   // December 31 2015 (Rare)
   private static final Pattern PATTERN_MONTH_DD_YYYY   = Pattern.compile(
                                                                          "(\\b((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\\b)");
   // DEC 31st 2015 (Rare)
   private static final Pattern PATTERN_MMM_DDSS_YYYY   = Pattern.compile(
                                                                          "(\\b((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\\b)");
   // December 31st 2015 (Rare)
   private static final Pattern PATTERN_MONTH_DDSS_YYYY = Pattern.compile(
                                                                          "(\\b((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\\b)");
   // 2015-31-12 (Commonly Used)
   private static final Pattern PATTERN_YYYY_DD_MM      = Pattern.compile(
                                                                          "(\\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\\-| )((0?[1-9])|(1[0-2]))\\b)");
   // 2015 31 DEC (Rare)
   private static final Pattern PATTERN_YYYY_DD_MMM     = Pattern.compile(
                                                                          "(\\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))\\b)");
   // 2015 31 December (Rare)
   private static final Pattern PATTERN_YYYY_DD_MONTH   = Pattern.compile(
                                                                          "(\\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))\\b)");
   // 2015 31st DEC (Rare)
   private static final Pattern PATTERN_YYYY_DDSS_MMM   = Pattern.compile(
                                                                          "(\\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))\\b)");
   // 2015 31st December (Rare)
   private static final Pattern PATTERN_YYYY_DDSS_MONTH = Pattern.compile(
                                                                          "(\\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))\\b)");

   // 2015-12-31 (Commonly Used)
   private static final Pattern PATTERN_YYYY_MM_DD      = Pattern.compile(
                                                                          "(\\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\\-| )((0?[1-9])|(1[0-2]))(/|\\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))\\b)");
   // 2015 DEC 31 (Rare)
   private static final Pattern PATTERN_YYYY_MMM_DD     = Pattern.compile(
                                                                          "(\\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))\\b)");
   // 2015 December 31 (Rare)
   private static final Pattern PATTERN_YYYY_MONTH_DD   = Pattern.compile(
                                                                          "(\\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))\\b)");
   // 2015 DEC 31st (Rare)
   private static final Pattern PATTERN_YYYY_MMM_DDSS   = Pattern.compile(
                                                                          "(\\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))\\b)");
   // 2015 December 31st (Rare)
   private static final Pattern PATTERN_YYYY_MONTH_DDSS = Pattern.compile(
                                                                          "(\\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))\\b)");

   // 8 frequently used patterns.
   private static final List<Pattern> commonDatePatterns = Arrays.asList(new Pattern[] { PATTERN_DD_MM_YYYY,
                                                                                         PATTERN_DD_MMM_YYYY,
                                                                                         PATTERN_DD_MONTH_YYYY,
                                                                                         PATTERN_DDSS_MMM_YYYY,
                                                                                         PATTERN_DDSS_MONTH_YYYY,
                                                                                         PATTERN_MM_DD_YYYY,
                                                                                         PATTERN_YYYY_DD_MM,
                                                                                         PATTERN_YYYY_MM_DD });

   // 12 rarely used patterns.
   private static final List<Pattern> rareDatePatterns = Arrays.asList(new Pattern[] { PATTERN_MMM_DD_YYYY,
                                                                                       PATTERN_MONTH_DD_YYYY,
                                                                                       PATTERN_MMM_DDSS_YYYY,
                                                                                       PATTERN_MONTH_DDSS_YYYY,
                                                                                       PATTERN_YYYY_DD_MMM,
                                                                                       PATTERN_YYYY_DD_MONTH,
                                                                                       PATTERN_YYYY_DDSS_MMM,
                                                                                       PATTERN_YYYY_DDSS_MONTH,
                                                                                       PATTERN_YYYY_MMM_DD,
                                                                                       PATTERN_YYYY_MONTH_DD,
                                                                                       PATTERN_YYYY_MMM_DDSS,
                                                                                       PATTERN_YYYY_MONTH_DDSS });

   public static boolean isDate(String data) {
      if(data == null || data.trim().isEmpty()) {
         return false;
      }
      boolean isDate = false;
      // check against frequently used Date patterns.
      for (Pattern p : commonDatePatterns) {
         if (p.matcher(data).matches()) {
            isDate = true;
            break;
         }
      }
      // If still not matching, then try with Rate Date formats.
      if (!isDate) {
         for (Pattern p : rareDatePatterns) {
            if (p.matcher(data).matches()) {
               isDate = true;
               break;
            }
         }
      }
      return isDate;
   }

   public static void main(String[] args) {
      String[] validDates = new String[] { "31-12-2015",
                                           "31/12/2015",
                                           "31 12 2015",
                                           "31-Dec-2015",
                                           "31-DEC-2015",
                                           "31-dec-2015",
                                           "31/January/2015",
                                           "1-JANUARY-2015",
                                           "10 january 2015",
                                           "1st Jan 2015",
                                           "3rd dec 2015",
                                           "30th-FEB-2015",
                                           "21st/MAY/0001",
                                           "31st December 2015",
                                           "1st JANUARY 2015",
                                           "23rd february 1995",
                                           "12-31-2015",
                                           "12/31/2015",
                                           "12 31 2015",
                                           "Dec-31-2015",
                                           "DEC/31/2015",
                                           "dec 31 2015",
                                           "December-31-2015",
                                           "DECEMBER/31/2015",
                                           "december 31 2015",
                                           "Dec-31st-2015",
                                           "DEC/11th/2015",
                                           "dec 23rd 2015",
                                           "December-31st-2015",
                                           "DECEMBER/11th/2015",
                                           "december 23rd 2015",
                                           "2015-31-12",
                                           "2015/31/12",
                                           "2015 31 12",
                                           "2015-31-Dec",
                                           "2015/31/DEC",
                                           "2015 31 dec",
                                           "2015-31-December",
                                           "2015/31/DECEMBER",
                                           "2015 31 december",
                                           "2015-31st-Dec",
                                           "2015/23rd/DEC",
                                           "2015 11th dec",
                                           "2015-31st-December",
                                           "2015/23rd/DECEMBER",
                                           "2015 11th december",
                                           "2015-12-31",
                                           "2015/12/31",
                                           "2015 12 31",
                                           "2015-DEC-31",
                                           "2015/dec/31",
                                           "2015 Dec 31",
                                           "2015-DECEMBER-31",
                                           "2015/december/31",
                                           "2015 December 31",
                                           "2015-DEC-31st",
                                           "2015/dec/11th",
                                           "2015 Dec 23rd",
                                           "2015-DECEMBER-31st",
                                           "2015/december/11th",
                                           "2015 December 23rd" };
      for (String data : validDates) {
         System.out.println(String.format("%30s : %s", data, DateChecker.isDate(data)));
      }
      
      String[] invalidDates = new String[] { "33-13-2015",
                                           "31/12/0000",
                                           "31 99 2015",
                                           "31-Decem-2015",
                                           "31-DECEM-2015",
                                           "31-xyz-2015",
                                           "31/Chanuary/2015",
                                           "32-JANUARY-2015",
                                           "10 janu 2015",
                                           "1rd Jan 2015",
                                           "3th dec 2015",
                                           "30st-FEB-2015",
                                           "21rd/MAY/0000",
                                           "31st cucumber 2015",
                                           "1rd JANUARY 2015",
                                           "11rd february 1995",
                                           "12-32-2015",
                                           "13/31/2015",
                                           "12 31 2k",
                                           "Dec-32-2015",
                                           "DECEM/31/2015",
                                           "decem 33 2015",
                                           "December-31th-2015",
                                           "DECEM/31/2015",
                                           "decem 31 2015",
                                           "Dec-31rd-2015",
                                           "DEC/11st/2015",
                                           "xyz 23rd 2015",
                                           "December-32nd-2015",
                                           "DECEMBER/41st/2015",
                                           "decembe 23rd 2015",
                                           "2015-33-12",
                                           "2015/31/0",
                                           "2015 00 12",
                                           "0-31-Dec",
                                           "2k/31/DEC",
                                           "2015 33 dec",
                                           "2015-31-cucumber",
                                           "2015/35/DECEMBER",
                                           "2015 31 decem",
                                           "2015-31st-Decem",
                                           "2015/23rd/ABC",
                                           "2015 11rd dec",
                                           "2015-31th-December",
                                           "2015/23st/DECEMBER",
                                           "2015 11nd december",
                                           "2015-12-32",
                                           "2015/13/31",
                                           "2015 13 31",
                                           "2k-DEC-31",
                                           "2015/decem/32",
                                           "2015 Dec 33",
                                           "201a-DECEMBER-31",
                                           "2015/decembers/31",
                                           "2015 December 99",
                                           "2015-DEC-31nd",
                                           "2015/dec/11rd",
                                           "2015 Dec 23st",
                                           "2015-DECEMBE-31st",
                                           "2015/ecember/11th",
                                           "2015 December 24rd" };
      
      
      System.out.println("Checking invalid Dates....");
      
      for (String data : invalidDates) {
         System.out.println(String.format("%30s : %s", data, DateChecker.isDate(data)));
      }
   }
}


/*
 
                    31-12-2015 : true
                    31/12/2015 : true
                    31 12 2015 : true
                   31-Dec-2015 : true
                   31-DEC-2015 : true
                   31-dec-2015 : true
               31/January/2015 : true
                1-JANUARY-2015 : true
               10 january 2015 : true
                  1st Jan 2015 : true
                  3rd dec 2015 : true
                 30th-FEB-2015 : true
                 21st/MAY/0001 : true
            31st December 2015 : true
              1st JANUARY 2015 : true
            23rd february 1995 : true
                    12-31-2015 : true
                    12/31/2015 : true
                    12 31 2015 : true
                   Dec-31-2015 : true
                   DEC/31/2015 : true
                   dec 31 2015 : true
              December-31-2015 : true
              DECEMBER/31/2015 : true
              december 31 2015 : true
                 Dec-31st-2015 : true
                 DEC/11th/2015 : true
                 dec 23rd 2015 : true
            December-31st-2015 : true
            DECEMBER/11th/2015 : true
            december 23rd 2015 : true
                    2015-31-12 : true
                    2015/31/12 : true
                    2015 31 12 : true
                   2015-31-Dec : true
                   2015/31/DEC : true
                   2015 31 dec : true
              2015-31-December : true
              2015/31/DECEMBER : true
              2015 31 december : true
                 2015-31st-Dec : true
                 2015/23rd/DEC : true
                 2015 11th dec : true
            2015-31st-December : true
            2015/23rd/DECEMBER : true
            2015 11th december : true
                    2015-12-31 : true
                    2015/12/31 : true
                    2015 12 31 : true
                   2015-DEC-31 : true
                   2015/dec/31 : true
                   2015 Dec 31 : true
              2015-DECEMBER-31 : true
              2015/december/31 : true
              2015 December 31 : true
                 2015-DEC-31st : true
                 2015/dec/11th : true
                 2015 Dec 23rd : true
            2015-DECEMBER-31st : true
            2015/december/11th : true
            2015 December 23rd : true
Checking invalid Dates....
                    33-13-2015 : false
                    31/12/0000 : false
                    31 99 2015 : false
                 31-Decem-2015 : false
                 31-DECEM-2015 : false
                   31-xyz-2015 : false
              31/Chanuary/2015 : false
               32-JANUARY-2015 : false
                  10 janu 2015 : false
                  1rd Jan 2015 : false
                  3th dec 2015 : false
                 30st-FEB-2015 : false
                 21rd/MAY/0000 : false
            31st cucumber 2015 : false
              1rd JANUARY 2015 : false
            11rd february 1995 : false
                    12-32-2015 : false
                    13/31/2015 : false
                      12 31 2k : false
                   Dec-32-2015 : false
                 DECEM/31/2015 : false
                 decem 33 2015 : false
            December-31th-2015 : false
                 DECEM/31/2015 : false
                 decem 31 2015 : false
                 Dec-31rd-2015 : false
                 DEC/11st/2015 : false
                 xyz 23rd 2015 : false
            December-32nd-2015 : false
            DECEMBER/41st/2015 : false
             decembe 23rd 2015 : false
                    2015-33-12 : false
                     2015/31/0 : false
                    2015 00 12 : false
                      0-31-Dec : false
                     2k/31/DEC : false
                   2015 33 dec : false
              2015-31-cucumber : false
              2015/35/DECEMBER : false
                 2015 31 decem : false
               2015-31st-Decem : false
                 2015/23rd/ABC : false
                 2015 11rd dec : false
            2015-31th-December : false
            2015/23st/DECEMBER : false
            2015 11nd december : false
                    2015-12-32 : false
                    2015/13/31 : false
                    2015 13 31 : false
                     2k-DEC-31 : false
                 2015/decem/32 : false
                   2015 Dec 33 : false
              201a-DECEMBER-31 : false
             2015/decembers/31 : false
              2015 December 99 : false
                 2015-DEC-31nd : false
                 2015/dec/11rd : false
                 2015 Dec 23st : false
             2015-DECEMBE-31st : false
             2015/ecember/11th : false
            2015 December 24rd : false

 
 */
