select u.urun_id, uys.urun_id as bagli_urun_id
from istatistiki_urun_iliski i
         inner join urun_gecici u on i.istatistiki_urun_kod1 = u.eski_urun_id
         inner join urun_gecici uys on i.istatistiki_urun_kod2 = uys.eski_urun_id;