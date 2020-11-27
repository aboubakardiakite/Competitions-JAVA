CC = javac
EXE = java

.PHONY: all doc test clean

all :
	 cd src && $(CC) -d ../classes competition/*.java && cd ../   &&  $(EXE) -cp classes competition.LeagueMain  &&  $(EXE) -cp classes competition.TournamentMain  &&  $(EXE) -cp classes competition.MasterMain;

doc :
	 cd src ;javadoc -d ../docs * ;cd .. ;

test :
	$(CC) -cp test-1.7.jar:class -sourcepath src:test test/competition/*.java ;
	$(EXE) -jar test-1.7.jar competition.CompetitorTest &
	$(EXE) -jar test-1.7.jar competition.MatchTest &
	$(EXE) -jar test-1.7.jar competition.LeagueTest &
	$(EXE) -jar test-1.7.jar competition.TournamentTest &
	$(EXE) -jar test-1.7.jar competition.MasterTest &
	$(EXE) -jar test-1.7.jar competition.SelectFirstTest &
	$(EXE) -jar test-1.7.jar competition.SelectFirstTwoTest &
	$(EXE) -jar test-1.7.jar competition.SelectFirstTwoAndBestThirdsTest &


clean :
	rm rm -rf classes/* && rm -rf docs/*  ;
