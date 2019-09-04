import requests
from bs4 import BeautifulSoup
url = 'https://www.fangraphs.com/leaders.aspx?pos=all&stats=rel&lg=all&qual=0&type=8&season=2019&month=0&season1=2019&ind=0&team=0,ts&rost=0&age=0&filter=&players=0';
headers = {'User-Agent': 'Mozilla/5.0'};
response = requests.get(url, headers = headers);
soup = BeautifulSoup(response.content, 'html.parser');
relief_stats = soup.find_all('table', class_ = 'rgMasterTable' );
relief_stats = relief_stats[0];


with open ('relief_stats.txt', 'w') as r:
    for row in relief_stats.find_all('tr', class_ = ['rgRow', 'rgAltRow']):
        for cell in row.find_all('td'):
            r.write(cell.text.ljust(15));
        r.write('\n');



url2 = 'https://www.fangraphs.com/leaders.aspx?pos=all&stats=pit&lg=all&qual=10&type=8&season=2019&month=0&season1=2019&ind=0&team=0&rost=0&age=0&filter=&players=p2019-09-04&startdate=&enddate='
response2 = requests.get(url2, headers = headers);
soup2 = BeautifulSoup(response2.content, 'html.parser');
starters = soup2.find_all('table', class_ = 'rgMasterTable');
starters = starters[0];

with open ('daily_starters.txt', 'w') as r:
	for row in starters.find_all('tr', class_ = ['rgRow', 'rgAltRow']):
		for cell in row.find_all('td'):
			r.write(cell.text.ljust(15));
		r.write('\n');

def function getPitchingInfo(url, response, soup, table):
    headers = {'User-Agent': 'Mozilla/5.0'};
