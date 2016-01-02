#######################################################################################
#	Evolution of an UNIVERSAL Regular Expression pattern for matching DATE.
# 
#		@Author: Nataraj Gnanavadivel
#		@Date: 1st January 2015
#######################################################################################

#--------------------------
[YEAR]
#--------------------------

Regex to match anything b/w 1 to 9999 irrespective of zeroes padded in the front or # of digits.

Samples to Match:

01
001
0001
010
0010
0100
1
10
100
1000
1111
9999

0 | 00 | 000 | 0000 | 10000 | 99999

[YEAR's REGEX - Evolution - Re-arranged to match the largest word]

(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9])						-> 1 - 9 (OR) 01- 09 (OR) 001 - 009 (OR) 010 - 099 (OR) 0100 - 0999 (OR) 0001 - 0009
[1-9][0-9]{1,3} 														-> 10 - 99 (OR) 100 - 999 (OR) 1000 - 9999

[YEARS - FINAL REGEX]

\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\b

#--------------------------
[Month - Numeric]
#--------------------------

Regex to match anything from 1 to 12 irrespective of zeroes padded in the front or # of digits.

Samples to Match:

01
09
1
9
10
11
12

13 | 100 | 00


[REGEX]

\b((0?[1-9])|(1[0-2]))\b

#--------------------------
[Month - Literal (3 Letters)]
#--------------------------

Regex to match anything from JAN - DEC irrespective of case.

Samples to Match:

JAN | jan | Jan
FEB | feb | Feb
MAR | mar | Mar
APR | apr | Apr
MAY | may | May
JUN | jun | Jun
JUL | jul | Jul
AUG | aug | Aug
SEP | sep | Sep
OCT | oct | Oct
NOV | nov | Nov
DEC | dec | Dec 


xxx | abc | Xpq | kolavery

[REGEX]

\b((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))\b


#--------------------------
[Month - Literal (Full Words)]
#--------------------------

Regex to match anything from JANUARY - DECEMBER irrespective of case.

Samples to Match:

JANUARY | january | January
FEBRUARY | february | February
MARCH | march | March
APRIL | april | April
MAY | may | May
JUNE | june | June
JULY | july | July
AUGUST | august | August
SEPTEMBER | september | September
OCTOBER | october | October
NOVEMBER | november | November
DECEMBER | december | December 


Nataraj | gnanavadivel | EBRUARY | ARCH | uly | EMBER | ust | kolavery

[REGEX]

\b((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))\b

#----------------
[Day - Numeric 
#----------------

Regex to match anything from 1 - 31 irrespective of zeros padded in front.

Samples to Match:

01
09
10
11
19
20
21
29
30
31

32 | 100 | 00 | 0

[REGEX]

\b((0?[1-9])|([1-2][0-9])|([3][0-1]))\b

#--------------------------------
[Day - Numeric And Superscript 
#--------------------------------

Regex to match anything from 1st, 2nd, 3rd....31st kinda of syntaxes.

Samples to Match:

1st | 21st | 31st
2nd | 22nd
3rd | 23rd
4th | 10th | 11th | 12th | 19th | 20th | 24th | 29th | 30th


1nd  | 2rd | 31th | 10st  | 41st | 42nd | 53rd

\b((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))\b

#--------------------------------
[Date Delimiters 
#--------------------------------

[REGEX]

((/|\-| )

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	1.0.  Combined Version - DAY_NUMERIC|MONTH_NUMERIC|YEAR						31|12|2015
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\-| )((0?[1-9])|(1[0-2]))(/|\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\b)

31-12-2015
31/12/2015
31 12 2015

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	1.1.  Combined Version - DAY_NUMERIC|MONTH_3_LTR|YEAR						31|Dec|2015
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\b)

31-Dec-2015
31-DEC-2015
31-dec-2015

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	1.2.  Combined Version - DAY_NUMERIC|MONTH_ALL_LTRS|YEAR					31|December|2015	
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\b)

31/January/2015
1-JANUARY-2015
10 january 2015

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	1.3.  Combined Version - DAY_NUMERIC_SUPERSCRIPT|MONTH_3_LTR|YEAR			31st|Dec|2015
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\b)

1st Jan 2015
3rd dec 2015
30th-FEB-2015
21st/MAY/0001

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	1.4.  Combined Version - DAY_NUMERIC_SUPERSCRIPT|MONTH_ALL_LTRS|YEAR		31st|December|2015
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\b)

31st December 2015
1st JANUARY 2015
23rd february 1995

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	2.0.  Combined Version - MONTH_NUMERIC|DAY_NUMERIC|YEAR						12|31|2015
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b((0?[1-9])|(1[0-2]))(/|\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\b)

12-31-2015
12/31/2015
12 31 2015

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	2.1.  Combined Version - MONTH_3_LTR|DAY_NUMERIC|YEAR						Dec|31|2015
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\b)

Dec-31-2015
DEC/31/2015
dec 31 2015

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	2.2.  Combined Version - MONTH_ALL_LTRS|DAY_NUMERIC|YEAR					December|31|2015	
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\b)

December-31-2015
DECEMBER/31/2015
december 31 2015

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	2.3.  Combined Version - MONTH_3_LTR|DAY_NUMERIC_SUPERSCRIPT|YEAR			Dec|31st|2015
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\b)

Dec-31st-2015
DEC/11th/2015
dec 23rd 2015


#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	2.4.  Combined Version - MONTH_ALL_LTRS|DAY_NUMERIC_SUPERSCRIPT|YEAR		December|31st|2015
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\-| )(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))\b)

December-31st-2015
DECEMBER/11th/2015
december 23rd 2015


#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	3.0.  Combined Version - YEAR|DAY_NUMERIC|MONTH_NUMERIC						2015|31|12
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\-| )((0?[1-9])|(1[0-2]))\b)

2015-31-12
2015/31/12
2015 31 12


#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	3.1.  Combined Version - YEAR|DAY_NUMERIC|MONTH_3_LTR						2015|31|Dec
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))\b)

2015-31-Dec
2015/31/DEC
2015 31 dec

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	3.2.  Combined Version - YEAR|DAY_NUMERIC|MONTH_ALL_LTRS					2015|31|December	
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))(/|\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))\b)

2015-31-December
2015/31/DECEMBER
2015 31 december

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	3.3.  Combined Version - YEAR|DAY_NUMERIC_SUPERSCRIPT|MONTH_3_LTR			2015|31st|Dec
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))\b)

2015-31st-Dec
2015/23rd/DEC
2015 11th dec

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	3.4.  Combined Version - YEAR|DAY_NUMERIC_SUPERSCRIPT|MONTH_ALL_LTRS		2015|31st|December
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))(/|\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))\b)

2015-31st-December
2015/23rd/DECEMBER
2015 11th december

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	4.0.  Combined Version - YEAR|MONTH_NUMERIC|DAY_NUMERIC						2015|12|31
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\-| )((0?[1-9])|(1[0-2]))(/|\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))\b)

2015-12-31
2015/12/31
2015 12 31

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	4.1.  Combined Version - YEAR|MONTH_3_LTR|DAY_NUMERIC						2015|Dec|31
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))\b)

2015-DEC-31
2015/dec/31
2015 Dec 31

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	4.2.  Combined Version - YEAR|MONTH_ALL_LTRS|DAY_NUMERIC					2015|December|31	
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\-| )((0?[1-9])|([1-2][0-9])|([3][0-1]))\b)

2015-DECEMBER-31
2015/december/31
2015 December 31

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	4.3.  Combined Version - YEAR|MONTH_3_LTR|DAY_NUMERIC_SUPERSCRIPT			2015|Dec|31st
#---------------------------------------------------------------------------------------------------------------------------------------------------------------


(\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\-| )((J(AN|an)|(jan))|(F(EB|eb)|(feb))|(M(AR|ar)|(mar))|(A(PR|pr)|(apr))|(M(AY|ay)|(may))|(J(UN|un)|(jun))|(J(UL|ul)|(jul))|(A(UG|ug)|(aug))|(S(EP|ep)|(sep))|(O(CT|ct)|(oct))|(N(OV|ov)|(nov))|(D(EC|ec)|(dec)))(/|\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))\b)

2015-DEC-31st
2015/dec/11th
2015 Dec 23rd

#---------------------------------------------------------------------------------------------------------------------------------------------------------------
	4.4.  Combined Version - YEAR|MONTH_ALL_LTRS|DAY_NUMERIC_SUPERSCRIPT		2015|December|31st
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

(\b(([1-9][0-9]{1,3})|(0[1-9][0-9][0-9])|(0{1,2}[1-9][0-9])|(0{0,3}[1-9]))(/|\-| )((J(ANUARY|anuary)|(january))|(F(EBRUARY|ebruary)|(february))|(M(ARCH|arch)|(march))|(A(PRIL|pril)|(april))|(M(AY|ay)|(may))|(J(UNE|une)|(june))|(J(ULY|uly)|(july))|(A(UGUST|ugust)|(august))|(S(EPTEMBER|eptember)|(september))|(O(CTOBER|ctober)|(october))|(N(OVEMBER|ovember)|(november))|(D(ECEMBER|ecember)|(december)))(/|\-| )((((1)|([2-3]1))(st|ST))|(22?(nd|ND))|((3|23)(rd|RD))|(([4-9]|[1][1-9]|2[4-9]|[1-3]0)(th|TH)))\b)

2015-DECEMBER-31st
2015/december/11th
2015 December 23rd


#---------------------------------------------------------------------------------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------------------------------------------------------------------------------

* ---- JAVA STRING PATTERN EQUIVALENTS ------- *

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

