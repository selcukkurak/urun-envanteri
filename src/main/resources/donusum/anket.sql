select anket_kod as id,
       anket_ad as adi,
       csa,
       ic_birim_kod as birim_id,
       (select id from rf_toplu r where r.kodu = calisma_periyot and tipi = 'PERIYOT') as periyot_id,
       (select id from rf_toplu r where r.kodu = cografi_duzey_kod and tipi = 'COGRAFI_DUZEY') as cografi_duzey_id,
       (select id from rf_toplu r where r.kodu = veri_birim_duzey and tipi = 'ISTATISTIKI_BIRIM_DUZEYI') as birim_duzey_id,
       orneklem_sayisi,
       calisma_sema as sema,
       harzemli_durum,
       ust_durum_kod as ust_durum
from anket_calismasi_envanteri as anket;
