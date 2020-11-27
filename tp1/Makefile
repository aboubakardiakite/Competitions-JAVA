CC = javac
EXE = java

.PHONY: all doc test clean

all :
	 cd src && $(CC) -d ../classes competition/*.java && cd ../   &&  $(EXE) -cp classes competition.CompetitionMain;

doc :
	 cd src ;javadoc -d ../docs * ;cd .. ;

test :
	$(CC) -cp test-1.7.jar:class -sourcepath src:test test/competition/*.java ;
	$(EXE) -jar test-1.7.jar competition.CompetitorTest &
	$(EXE) -jar test-1.7.jar competition.MatchTest &
	$(EXE) -jar test-1.7.jar competition.LeagueTest &
	$(EXE) -jar test-1.7.jar competition.TournamentTest &


clean :
	rm rm -rf classes/* && rm -rf docs/*  ;
