import requests
from bs4 import BeautifulSoup

class Stat_Scraper:
    headers = {'User-Agent': 'Mozilla/5.0'};

    def __init__(self,url,scriptName):
        self.url=url
        self.scriptName=scriptName

    def createScript(self):
           response = requests.get(self.url, headers = self.headers);
           soup = BeautifulSoup(response.content, 'html.parser');
           stats = soup.find_all('table', class_ = 'rgMasterTable' );
           stats = stats[0];
           with open (self.scriptName+'.txt', 'w') as r:
               for row in stats.find_all('tr', class_ = ['rgRow', 'rgAltRow']):
                   for cell in row.find_all('td'):
                       print(cell.text.ljust(20))
                       r.write(cell.text.ljust(20));
                   r.write('\n');

sS= Stat_Scraper('https://www.fangraphs.com/leaders.aspx?pos=all&stats=rel&lg=all&qual=0&type=8&season=2019&month=0&season1=2019&ind=0&team=0,ts&rost=0&age=0&filter=&players=0',"BullPenStats")
sS.createScript()

starterStats=Stat_Scraper('https://www.fangraphs.com/leaders.aspx?pos=all&stats=pit&lg=all&qual=10&type=8&season=2019&month=0&season1=2019&ind=0&team=0&rost=0&age=0&filter=&players=p2019-09-04&startdate=&enddate=',"StarterStats")
starterStats.createScript()
