import requests
from bs4 import BeautifulSoup

class Stat_Scraper:
    headers = {'User-Agent': 'Mozilla/5.0'};

    def __init__(self,url,scriptName, className):
        self.url=url
        self.scriptName=scriptName
        self.className = className

    def createScript(self):
           response = requests.get(self.url, headers = self.headers);
           soup = BeautifulSoup(response.content, 'html.parser');
           stats = soup.find_all('table', class_ = self.className );
           stats = stats[0];
           with open (self.scriptName+'.txt', 'w') as r:
               for row in stats.find_all('tr', class_ = ['rgRow', 'rgAltRow', 'depth_team']):
                   for cell in row.find_all('td'):
                       r.write(cell.text.ljust(20));
                   r.write('\n');

sS= Stat_Scraper('https://www.fangraphs.com/leaders.aspx?pos=all&stats=rel&lg=all&qual=0&type=8&season=2019&month=0&season1=2019&ind=0&team=0,ts&rost=0&age=0&filter=&players=0',"BullpenStats", "rgMasterTable")
sS.createScript()

starterStats= Stat_Scraper('https://www.fangraphs.com/leaders.aspx?pos=all&stats=pit&lg=all&qual=10&type=8&season=2019&month=0&season1=2019&ind=0&team=0&rost=0&age=0&filter=&players=p2019-09-11&startdate=&enddate=',"StarterStats", "rgMasterTable")
starterStats.createScript()

offenseStats = Stat_Scraper("https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=0&type=8&season=2019&month=0&season1=2019&ind=0&team=0,ts&rost=&age=&filter=&players=0", "OffenseStats", "rgMasterTable")
offenseStats.createScript()

winPct = Stat_Scraper('https://www.fangraphs.com/depthcharts.aspx?position=Standings', "WinPct", "tablesoreder, depth_chart")
winPct.createScript()
