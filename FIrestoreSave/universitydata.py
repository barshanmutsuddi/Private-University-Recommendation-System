import requests
from bs4 import BeautifulSoup
import re
url = 'http://www.portcity.edu.bd/HomePage/DepatmentDetails/29/Portfolio/bachelor-s-degree-programs'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

pciu_data = soup.find_all("table", {"class": "table table-bordered"})


pciu_fees = []

for item in pciu_data:
    pciu_fees.append((item.contents[9].find_all('td')[1].text.strip().replace(',','').replace('Tk.','')))



pciu_bba = re.findall('\d+', pciu_fees[0])[0]
pciu_llb= re.findall('\d+', pciu_fees[1])[0]
pciu_eco = re.findall('\d+', pciu_fees[2])[0]
pciu_journ = re.findall('\d+', pciu_fees[3])[0]
pciu_cse = re.findall('\d+', pciu_fees[4])[0]
pciu_civil = re.findall('\d+', pciu_fees[5])[0]
pciu_eee = re.findall('\d+', pciu_fees[6])[0]
pciu_tex = re.findall('\d+', pciu_fees[7])[0]
pciu_bft = re.findall('\d+', pciu_fees[8])[0]
pciu_tour = re.findall('\d+', pciu_fees[9])[0]
pciu_pharma = re.findall('\d+', pciu_fees[10])[0]

#print(pciu_cse)

url = 'http://www.webometrics.info/en/Asia/Bangladesh%20?sort=asc&order=University'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

g_data = soup.find_all('tr', {'class': 'even'})

rank = []
fee = []
for item in g_data:
    fee.append(item.contents)

name1 = 'Port City International University'
n=0
for n in range(0, 50):
    if (fee[n][2].text == name1):
        pciu_ranking = fee[n][1].text
        break

#print(pciu_ranking)



url = 'http://www.ciu.edu.bd/tuition-fees.html'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

g_data = soup.find_all("div", {"class": "tab-content"})


ciu_data = []
for item in g_data:
    ciu_bba = (item.contents[1].find_all('tr')[4].find_all('td')[1].text.replace(',','').replace(' ','').strip())
    ciu_data.append(item.contents[3].find_all('table', {'class': 'table table-striped'})[1].find_all('td')[17].text.replace(',','').replace(' ','').strip())
    ciu_eng = (item.contents[5].find_all('tr')[6].find_all('td')[1].text.replace(',','').replace(' ','').strip())
    ciu_llb = (item.contents[7].find_all('tr')[6].find_all('td')[1].text.replace(',','').replace(' ','').strip())

ciu_cse = ciu_data[0]
ciu_eee = ciu_data[0]
ciu_ete = ciu_data[0]

#print(ciu_bba)


url = 'http://www.webometrics.info/en/Asia/Bangladesh%20?sort=asc&order=University'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

g_data = soup.find_all('tr', {'class': 'even'})

rank = []
fee = []
for item in g_data:
    fee.append(item.contents)

name1 = 'Chittagong Independent University'
n=0
for n in range(0, 50):
    if (fee[n][2].text == name1):
        ciu_ranking = fee[n][1].text
        break

#print(ciu_ranking)



url = 'https://www.uctc.edu.bd/academic/tuition-fee'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

uctc_data = soup.find_all("div", {"id": "categoryDiv"})


uctc_fees= []
for item in uctc_data:

    uctc_bba = (item.contents[3].find_all('tr')[1].find_all('td')[10].text.replace(',','').replace(' ','').strip())
    uctc_eng = (item.contents[3].find_all('tr')[2].find_all('td')[10].text.replace(',','').replace(' ','').strip())
    uctc_mec = (item.contents[3].find_all('tr')[3].find_all('td')[10].text.replace(',','').replace(' ','').strip())
    uctc_civil = (item.contents[3].find_all('tr')[5].find_all('td')[10].text.replace(',','').replace(' ','').strip())
    uctc_cse = (item.contents[3].find_all('tr')[7].find_all('td')[10].text.replace(',','').replace(' ','').strip())


#print(uctc_bba)



url = 'http://britannia.ac/node/44'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

britania_data = soup.find_all('div', {'class': 'field-item even'})


for item in britania_data:
    britania_bba = item.contents[5].find_all('tr')[1].find_all('td')[2].text.strip().replace(',','')
    britania_cse = item.contents[5].find_all('tr')[2].find_all('td')[2].text.strip().replace(',', '')
    britania_eng = item.contents[5].find_all('tr')[4].find_all('td')[2].text.strip().replace(',', '')
    britania_llb = item.contents[5].find_all('tr')[5].find_all('td')[2].text.strip().replace(',', '')
    britania_eco = item.contents[5].find_all('tr')[6].find_all('td')[2].text.strip().replace(',', '')

#print(britania_eco)

url = 'http://www.webometrics.info/en/Asia/Bangladesh%20?sort=asc&order=University'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

g_data = soup.find_all('tr', {'class': 'even'})

rank = []
fee = []
for item in g_data:
    fee.append(item.contents)

name1 = 'Britannia University'
n=0
for n in range(0, 50):
    if (fee[n][2].text == name1):
        britania_ranking = fee[n][1].text
        break

#print(britania_ranking)


url = 'http://www.ewubd.edu/tuition-fees/'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

eastwest_data = soup.find_all('table', {'width': '670'})


for item in eastwest_data:
    eastwest_bba = item.contents[1].find_all('tr')[1].find_all('td')[6].text.strip().replace(',','').replace('/','').replace('=','')
    eastwest_eco = item.contents[1].find_all('tr')[2].find_all('td')[5].text.strip().replace(',','').replace('/','').replace('=','')
    eastwest_eng = item.contents[1].find_all('tr')[3].find_all('td')[6].text.strip().replace(',','').replace('/','').replace('=','')
    eastwest_socio = item.contents[1].find_all('tr')[4].find_all('td')[5].text.strip().replace(',','').replace('/','').replace('=','')
    eastwest_llb = item.contents[1].find_all('tr')[6].find_all('td')[5].text.strip().replace(',','').replace('/','').replace('=','')
    eastwest_stat = item.contents[1].find_all('tr')[7].find_all('td')[6].text.strip().replace(',','').replace('/','').replace('=','')
    eastwest_ete = item.contents[1].find_all('tr')[8].find_all('td')[5].text.strip().replace(',','').replace('/','').replace('=','')
    eastwest_cse = item.contents[1].find_all('tr')[10].find_all('td')[5].text.strip().replace(',','').replace('/','').replace('=','')
    eastwest_eee = item.contents[1].find_all('tr')[11].find_all('td')[5].text.strip().replace(',','').replace('/','').replace('=','')
    eastwest_pharma = item.contents[1].find_all('tr')[12].find_all('td')[5].text.strip().replace(',','').replace('/','').replace('=','')
    eastwest_genetic = item.contents[1].find_all('tr')[13].find_all('td')[5].text.strip().replace(',','').replace('/','').replace('=','')
    eastwest_civil = item.contents[1].find_all('tr')[14].find_all('td')[5].text.strip().replace(',','').replace('/','').replace('=','')



#print(eastwest_civil)


url = 'http://www.webometrics.info/en/Asia/Bangladesh%20?sort=asc&order=University'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

g_data = soup.find_all('tr', {'class': 'even'})

rank = []
fee = []
for item in g_data:
    fee.append(item.contents)

name1 = 'East West University Bangladesh'
n=0
for n in range(0, 50):
    if (fee[n][2].text == name1):
        eastwest_ranking = fee[n][1].text
        break

#print(eastwest_ranking)




url = 'https://daffodilvarsity.edu.bd/article/tuition-fee'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

daffodil_data = soup.find_all("table", {"class": "table table-bordered table-striped"})


daffodil_fee = []
for item in daffodil_data:
    daff_cse = item.contents[1].find_all('td', {'style': 'width: 135.883px;'})[1].text.strip().replace(',', '')
    daff_bft = item.contents[1].find_all('td', {'style': 'width: 135.883px;'})[10].text.strip().replace(',', '')
    daff_eee = item.contents[1].find_all('td', {'style': 'width: 135.883px;'})[12].text.strip().replace(',', '')
    daff_civil = item.contents[1].find_all('td', {'style': 'width: 135.883px;'})[16].text.strip().replace(',', '')
    daff_arch = item.contents[1].find_all('td', {'style': 'width: 135.883px;'})[18].text.strip().replace(',', '')
    daff_bba = item.contents[1].find_all('td', {'style': 'width: 135.883px;'})[21].text.strip().replace(',', '')
    daff_tour = item.contents[1].find_all('td', {'style': 'width: 135.883px;'})[22].text.strip().replace(',', '')
    daff_llb = item.contents[1].find_all('td', {'style': 'width: 135.883px;'})[28].text.strip().replace(',', '')
    daff_eng = item.contents[1].find_all('td', {'style': 'width: 135.883px;'})[29].text.strip().replace(',', '')
    daff_journ = item.contents[1].find_all('td', {'style': 'width: 135.883px;'})[30].text.strip().replace(',', '')
    daff_pharma = item.contents[1].find_all('td', {'style': 'width: 135.883px;'})[36].text.strip().replace(',', '')

#print(daff_pharma)


url = 'http://www.webometrics.info/en/Asia/Bangladesh%20?sort=asc&order=University'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

g_data = soup.find_all('tr', {'class': 'even'})

rank = []
fee = []
for item in g_data:
    fee.append(item.contents)

name1 = 'Daffodil International University'
n=0
for n in range(0, 50):
    if (fee[n][2].text == name1):
        daffodil_ranking = fee[n][1].text
        break

#print(daffodil_ranking)




url = 'http://www.uiu.ac.bd/admission/tuition-fees-payment-policies/tuition-fees-waiver/'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

uiu_data = soup.find_all("div", {"class": "entry-content"})


for item in uiu_data:
    uiu_bba = item.contents[3].find_all('tr')[4].find_all('td')[1].text.replace(',','').replace('Tk.','').strip()
    uiu_eco = item.contents[3].find_all('tr')[4].find_all('td')[3].text.replace(',','').replace('Tk.','').strip()
    uiu_cse = item.contents[3].find_all('tr')[4].find_all('td')[4].text.replace(',','').replace('Tk.','').strip()
    uiu_eee = item.contents[3].find_all('tr')[4].find_all('td')[5].text.replace(',','').replace('Tk.','').strip()


#print(uiu_eee)


url = 'http://www.webometrics.info/en/Asia/Bangladesh%20?page=1&sort=asc&order=University'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

g_data = soup.find_all('tr', {'class': 'even'})

rank = []
fee = []
for item in g_data:
    fee.append(item.contents)

name1 = 'United International University'
n=0
for n in range(0, 50):
    if (fee[n][2].text == name1):
        uiu_ranking = fee[n][1].text
        break

#print(uiu_ranking)



url = 'http://admissions.northsouth.edu/tuition'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

nsu_data = soup.find_all('div', {'class': 'tab-content'})

ranks = []
for item in nsu_data:
    arch1 = (item.contents[1].find_all('tr')[1].find_all('td')[1].text.strip().replace(',', ''))
    arch2 = (item.contents[1].find_all('tr')[1].find_all('td')[2].text.strip().replace(',', ''))
    arch3 = (item.contents[1].find_all('tr')[1].find_all('td')[3].text.strip().replace(',', ''))
    arch4 = (item.contents[1].find_all('tr')[1].find_all('td')[4].text.strip().replace(',', ''))
    arch5 = (item.contents[1].find_all('tr')[1].find_all('td')[5].text.strip().replace(',', ''))
    arch6 = (item.contents[1].find_all('tr')[1].find_all('td')[6].text.strip().replace(',', ''))
    arch7 = (item.contents[1].find_all('tr')[1].find_all('td')[7].text.strip().replace(',', ''))

    cse1 = (item.contents[1].find_all('tr')[2].find_all('td')[1].text.strip().replace(',', ''))
    cse2 = (item.contents[1].find_all('tr')[2].find_all('td')[2].text.strip().replace(',', ''))
    cse3 = (item.contents[1].find_all('tr')[2].find_all('td')[3].text.strip().replace(',', ''))
    cse4 = (item.contents[1].find_all('tr')[2].find_all('td')[4].text.strip().replace(',', ''))
    cse5 = (item.contents[1].find_all('tr')[2].find_all('td')[5].text.strip().replace(',', ''))
    cse6 = (item.contents[1].find_all('tr')[2].find_all('td')[6].text.strip().replace(',', ''))
    cse7 = (item.contents[1].find_all('tr')[2].find_all('td')[7].text.strip().replace(',', ''))

    eee1 = (item.contents[1].find_all('tr')[3].find_all('td')[1].text.strip().replace(',', ''))
    eee2 = (item.contents[1].find_all('tr')[3].find_all('td')[2].text.strip().replace(',', ''))
    eee3 = (item.contents[1].find_all('tr')[3].find_all('td')[3].text.strip().replace(',', ''))
    eee4 = (item.contents[1].find_all('tr')[3].find_all('td')[4].text.strip().replace(',', ''))
    eee5 = (item.contents[1].find_all('tr')[3].find_all('td')[5].text.strip().replace(',', ''))
    eee6 = (item.contents[1].find_all('tr')[3].find_all('td')[6].text.strip().replace(',', ''))
    eee7 = (item.contents[1].find_all('tr')[3].find_all('td')[7].text.strip().replace(',', ''))

    ete1 = (item.contents[1].find_all('tr')[4].find_all('td')[1].text.strip().replace(',', ''))
    ete2 = (item.contents[1].find_all('tr')[4].find_all('td')[2].text.strip().replace(',', ''))
    ete3 = (item.contents[1].find_all('tr')[4].find_all('td')[3].text.strip().replace(',', ''))
    ete4 = (item.contents[1].find_all('tr')[4].find_all('td')[4].text.strip().replace(',', ''))
    ete5 = (item.contents[1].find_all('tr')[4].find_all('td')[5].text.strip().replace(',', ''))
    ete6 = (item.contents[1].find_all('tr')[4].find_all('td')[6].text.strip().replace(',', ''))
    ete7 = (item.contents[1].find_all('tr')[4].find_all('td')[7].text.strip().replace(',', ''))

    bio1 = (item.contents[1].find_all('tr')[5].find_all('td')[1].text.strip().replace(',', ''))
    bio2 = (item.contents[1].find_all('tr')[5].find_all('td')[2].text.strip().replace(',', ''))
    bio3 = (item.contents[1].find_all('tr')[5].find_all('td')[3].text.strip().replace(',', ''))
    bio4 = (item.contents[1].find_all('tr')[5].find_all('td')[4].text.strip().replace(',', ''))
    bio5 = (item.contents[1].find_all('tr')[5].find_all('td')[5].text.strip().replace(',', ''))
    bio6 = (item.contents[1].find_all('tr')[5].find_all('td')[6].text.strip().replace(',', ''))
    bio7 = (item.contents[1].find_all('tr')[5].find_all('td')[7].text.strip().replace(',', ''))

    micro1 = (item.contents[1].find_all('tr')[6].find_all('td')[1].text.strip().replace(',', ''))
    micro2 = (item.contents[1].find_all('tr')[6].find_all('td')[2].text.strip().replace(',', ''))
    micro3 = (item.contents[1].find_all('tr')[6].find_all('td')[3].text.strip().replace(',', ''))
    micro4 = (item.contents[1].find_all('tr')[6].find_all('td')[4].text.strip().replace(',', ''))
    micro5 = (item.contents[1].find_all('tr')[6].find_all('td')[5].text.strip().replace(',', ''))
    micro6 = (item.contents[1].find_all('tr')[6].find_all('td')[6].text.strip().replace(',', ''))
    micro7 = (item.contents[1].find_all('tr')[6].find_all('td')[7].text.strip().replace(',', ''))

    pharma1 = (item.contents[1].find_all('tr')[7].find_all('td')[1].text.strip().replace(',', ''))
    pharma2 = (item.contents[1].find_all('tr')[7].find_all('td')[2].text.strip().replace(',', ''))
    pharma3 = (item.contents[1].find_all('tr')[7].find_all('td')[3].text.strip().replace(',', ''))
    pharma4 = (item.contents[1].find_all('tr')[7].find_all('td')[4].text.strip().replace(',', ''))
    pharma5 = (item.contents[1].find_all('tr')[7].find_all('td')[5].text.strip().replace(',', ''))
    pharma6 = (item.contents[1].find_all('tr')[7].find_all('td')[6].text.strip().replace(',', ''))
    pharma7 = (item.contents[1].find_all('tr')[7].find_all('td')[7].text.strip().replace(',', ''))

    environ1 = (item.contents[1].find_all('tr')[8].find_all('td')[1].text.strip().replace(',', ''))
    environ2 = (item.contents[1].find_all('tr')[8].find_all('td')[2].text.strip().replace(',', ''))
    environ3 = (item.contents[1].find_all('tr')[8].find_all('td')[3].text.strip().replace(',', ''))
    environ4 = (item.contents[1].find_all('tr')[8].find_all('td')[4].text.strip().replace(',', ''))
    environ5 = (item.contents[1].find_all('tr')[8].find_all('td')[5].text.strip().replace(',', ''))
    environ6 = (item.contents[1].find_all('tr')[8].find_all('td')[6].text.strip().replace(',', ''))
    environ7 = (item.contents[1].find_all('tr')[8].find_all('td')[7].text.strip().replace(',', ''))

    eng1 = (item.contents[1].find_all('tr')[9].find_all('td')[1].text.strip().replace(',', ''))
    eng2 = (item.contents[1].find_all('tr')[9].find_all('td')[2].text.strip().replace(',', ''))
    eng3 = (item.contents[1].find_all('tr')[9].find_all('td')[3].text.strip().replace(',', ''))
    eng4 = (item.contents[1].find_all('tr')[9].find_all('td')[4].text.strip().replace(',', ''))
    eng5 = (item.contents[1].find_all('tr')[9].find_all('td')[5].text.strip().replace(',', ''))
    eng6 = (item.contents[1].find_all('tr')[9].find_all('td')[6].text.strip().replace(',', ''))
    eng7 = (item.contents[1].find_all('tr')[9].find_all('td')[7].text.strip().replace(',', ''))

    eco1 = (item.contents[1].find_all('tr')[10].find_all('td')[1].text.strip().replace(',', ''))
    eco2 = (item.contents[1].find_all('tr')[10].find_all('td')[2].text.strip().replace(',', ''))
    eco3 = (item.contents[1].find_all('tr')[10].find_all('td')[3].text.strip().replace(',', ''))
    eco4 = (item.contents[1].find_all('tr')[10].find_all('td')[4].text.strip().replace(',', ''))
    eco5 = (item.contents[1].find_all('tr')[10].find_all('td')[5].text.strip().replace(',', ''))
    eco6 = (item.contents[1].find_all('tr')[10].find_all('td')[6].text.strip().replace(',', ''))
    eco7 = (item.contents[1].find_all('tr')[10].find_all('td')[7].text.strip().replace(',', ''))

    civil1 = (item.contents[1].find_all('tr')[11].find_all('td')[1].text.strip().replace(',', ''))
    civil2 = (item.contents[1].find_all('tr')[11].find_all('td')[2].text.strip().replace(',', ''))
    civil3 = (item.contents[1].find_all('tr')[11].find_all('td')[3].text.strip().replace(',', ''))
    civil4 = (item.contents[1].find_all('tr')[11].find_all('td')[4].text.strip().replace(',', ''))
    civil5 = (item.contents[1].find_all('tr')[11].find_all('td')[5].text.strip().replace(',', ''))
    civil6 = (item.contents[1].find_all('tr')[11].find_all('td')[6].text.strip().replace(',', ''))
    civil7 = (item.contents[1].find_all('tr')[11].find_all('td')[7].text.strip().replace(',', ''))

    llb1 = (item.contents[1].find_all('tr')[12].find_all('td')[1].text.strip().replace(',', ''))
    llb2 = (item.contents[1].find_all('tr')[12].find_all('td')[2].text.strip().replace(',', ''))
    llb3 = (item.contents[1].find_all('tr')[12].find_all('td')[3].text.strip().replace(',', ''))
    llb4 = (item.contents[1].find_all('tr')[12].find_all('td')[4].text.strip().replace(',', ''))
    llb5 = (item.contents[1].find_all('tr')[12].find_all('td')[5].text.strip().replace(',', ''))
    llb6 = (item.contents[1].find_all('tr')[12].find_all('td')[6].text.strip().replace(',', ''))
    llb7 = (item.contents[1].find_all('tr')[12].find_all('td')[7].text.strip().replace(',', ''))

    bba1 = (item.contents[1].find_all('tr')[13].find_all('td')[1].text.strip().replace(',', ''))
    bba2 = (item.contents[1].find_all('tr')[13].find_all('td')[2].text.strip().replace(',', ''))
    bba3 = (item.contents[1].find_all('tr')[13].find_all('td')[3].text.strip().replace(',', ''))
    bba4 = (item.contents[1].find_all('tr')[13].find_all('td')[4].text.strip().replace(',', ''))
    bba5 = (item.contents[1].find_all('tr')[13].find_all('td')[5].text.strip().replace(',', ''))
    bba6 = (item.contents[1].find_all('tr')[13].find_all('td')[6].text.strip().replace(',', ''))
    bba7 = (item.contents[1].find_all('tr')[13].find_all('td')[7].text.strip().replace(',', ''))

    hrm1 = (item.contents[1].find_all('tr')[14].find_all('td')[1].text.strip().replace(',', ''))
    hrm2 = (item.contents[1].find_all('tr')[14].find_all('td')[2].text.strip().replace(',', ''))
    hrm3 = (item.contents[1].find_all('tr')[14].find_all('td')[3].text.strip().replace(',', ''))
    hrm4 = (item.contents[1].find_all('tr')[14].find_all('td')[4].text.strip().replace(',', ''))
    hrm5 = (item.contents[1].find_all('tr')[14].find_all('td')[5].text.strip().replace(',', ''))
    hrm6 = (item.contents[1].find_all('tr')[14].find_all('td')[6].text.strip().replace(',', ''))
    hrm7 = (item.contents[1].find_all('tr')[14].find_all('td')[7].text.strip().replace(',', ''))


nsu_arch = int(arch1) + int(arch2) * 170 + int(arch3) * 11 + int(arch4) * 11 + int(arch5) * 11 + int(arch6) * 11 + int(arch7)
nsu_cse = int(cse1) + int(cse2) * 130 + int(cse3) * 10 + int(cse4) * 10 + int(cse5) * 10 + int(cse6) * 10 + int(cse7)
nsu_eee = int(eee1) + int(eee2) * 130 + int(eee3) * 10 + int(eee4) * 10 + int(eee5) * 10 + int(eee6) * 10 + int(eee7)
nsu_ete = int(ete1) + int(ete2) * 130 + int(ete3) * 10 + int(ete4) * 10 + int(ete5) * 10 + int(ete6) * 10 + int(ete7)
nsu_biochem = int(bio1) + int(bio2) * 120 + int(bio3) * 10 + int(bio4) * 10 + int(bio5) * 10 + int(bio6) * 10 + int(bio7)
nsu_micro = int(micro1) + int(micro2) * 120 + int(micro3) * 10 + int(micro4) * 10 + int(micro5) * 10 + int(micro6) * 10 + int(micro7)
nsu_pharma = int(pharma1) + int(pharma2) * 199 + int(pharma3) * 10 + int(pharma4) * 10 + int(pharma5) * 10 + int(pharma6) * 10 + int(pharma7)
nsu_environ = int(environ1) + int(environ2) * 130 + int(environ3) * 10 + int(environ4) * 10 + int(environ5) * 10 + int(environ6) * 10 + int(environ7)
nsu_eng = int(eng1) + int(eng2) * 123 + int(eng3) * 10 + int(eng4) * 10 + int(eng5) * 10 + int(eng6) * 10 + int(eng7)
nsu_eco = int(eco1) + int(eco2) * 120 + int(eco3) * 10 + int(eco4) * 10 + int(eco5) * 10 + int(eco6) * 10 + int(eco7)
nsu_civil = int(civil1) + int(civil2) * 149 + int(civil3) * 10 + int(civil4) * 10 + int(civil5) * 10 + int(civil6) * 10 + int(civil7)
nsu_llb = int(llb1) + int(llb2) * 130 + int(llb3) * 10 + int(llb4) * 10 + int(llb5) * 10 + int(llb6) * 10 + int(llb7)
nsu_hrm = int(hrm1) + int(hrm2) * 124 + int(hrm3) * 9 + int(hrm4) * 9 + int(hrm5) * 9 + int(hrm6) * 9 + int(hrm7)
nsu_bba = int(bba1) + int(bba2) * 120 + int(bba3) * 9 + int(bba4) * 9 + int(bba5) * 9 + int(bba6) * 9 + int(bba7)

#print(nsu_llb)

url = 'https://www.eastdelta.edu.bd/fees-tuition/'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

edu_data = soup.find_all("div",{"class": "single"})


for item in edu_data:
    #pciu_fees.append((item.contents[9].find_all('td')[1].text.strip().replace(',','').replace('Tk.','')))
    cse_data = item.contents[117].find_all('td')[11].text.strip().replace(',','').replace('BDT ','').replace('/-','')
    eee_data = item.contents[127].find_all('td')[11].text.strip().replace(',','').replace('BDT ','').replace('/-','')
    ete_data = item.contents[137].find_all('td')[11].text.strip().replace(',','').replace('BDT ','').replace('/-','')
    eco_data = item.contents[107].find_all('td')[11].text.strip().replace(',','').replace('BDT ','').replace('/-','')


cse = int(cse_data) * 160 / 12
edu_cse = int(cse)
eee = int(eee_data) * 159 / 12
edu_eee = int(eee)
ete = int(ete_data) * 159 / 12
edu_ete = int(ete)
eco = int(eco_data) * 120 / 12
edu_eco = int(eco)
#print(eee)


url = 'https://www.iiuc.ac.bd/program/tution-fee-bachelor'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

iiuc_data = soup.find_all('tr',{'class': 'row-5 active'})


for item in iiuc_data:
    #pciu_fees.append((item.contents[9].find_all('td')[1].text.strip().replace(',','').replace('Tk.','')))
    iiuc_cse = item.contents[7].text.strip().replace('TK.','').replace(',','').replace('/-', '')


#print(iiuc_cse)


url = 'http://www.vub.edu.bd/tuition-fee.php'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

victoria_data = soup.find_all('table',{'class': 'table table-bordered table-hover'})


for item in victoria_data:
    #pciu_fees.append((item.contents[9].find_all('td')[1].text.strip().replace(',','').replace('Tk.','')))
    victoria_cse = item.contents[3].find_all('tr')[6].find_all('td')[9].text
    victoria_bba = item.contents[3].find_all('tr')[7].find_all('td')[9].text
    victoria_eng = item.contents[3].find_all('tr')[8].find_all('td')[9].text


#print(victoria_bba)




url = 'http://www.webometrics.info/en/Asia/Bangladesh%20?sort=asc&order=University'

r = requests.get(url)

soup = BeautifulSoup(r.content, 'lxml')

g_data = soup.find_all('tr', {'class': 'odd'})

rank = []
fee = []
for item in g_data:
    fee.append(item.contents)

name1 = 'North South University Bangladesh'
n=0
for n in range(0, 50):
    if (fee[n][2].text == name1):
        nsu_ranking = fee[n][1].text
        break

#print(nsu_ranking)



