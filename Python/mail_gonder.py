
#-*- coding:utf-8 -*-
import smtplib

def giris(kelime):
    return raw_input(kelime).strip()

def baglan():
    sunucu = smtplib.SMTP_SSL('smtp.gmail.com', 465)
    sunucu.login("tugba.dal@bil.omu.edu.tr","sifre")
    return sunucu
 
def mailgonder():
    sunucu = baglan()
 
    gonderici = giris("Maili gonderenin mail adresi:")
    alici = giris("Maili alanın mail adresi:")
 
    konu = giris("Mailin konusu:")
    icerik = giris("Mailin icerigi:")
    mail = """ 
            Gonderen:   %s
            Konu:       %s
            Mesaj:      %s
            """% (gonderici,konu,icerik)
    #mail = "Gonderen:",gonderici,"Konu:",konu,"icerik:",icerik
    try:
        #maili gönderiyoruz. Aldığı parametreler gonderenin mail adresi, alıcının mail adresi, ve mail içeriği
        sunucu.sendmail(gonderici,alici,mail)
        print "Mail basarili bir sekilde gonderildi."
    except EOFError:
        print "Mail gonderilirken hata olustu."
 
    sunucu.quit()
mailgonder()

 
