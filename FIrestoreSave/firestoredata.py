import firebase_admin
from firebase_admin import credentials, firestore
import universitydata
cred = credentials.Certificate('./firestoretest-ab335-firebase-adminsdk-197vb-385cb3b037.json')
default_app = firebase_admin.initialize_app(cred)
db = firestore.client()


pciu_ref = db.collection(u'chittagong').document(u'pciu')


pciu_ref.update({
    u'bba': universitydata.pciu_bba,
    u'eco': universitydata.pciu_eco,
    u'tex': universitydata.pciu_tex,
    u'bft': universitydata.pciu_bft,
    u'civil':universitydata.pciu_civil,
    u'eee': universitydata.pciu_eee,
    u'journ': universitydata.pciu_journ,
    u'tour': universitydata.pciu_tour,
    u'pharma': universitydata.pciu_pharma,
    u'cse': universitydata.pciu_cse,
    u'llb': universitydata.pciu_llb,
    u'ranking': universitydata.pciu_ranking
})

ciu_ref = db.collection(u'chittagong').document(u'ciu')

ciu_ref.update({
    u'bba': universitydata.ciu_bba,
    u'cse': universitydata.ciu_cse,
    u'eee': universitydata.ciu_eee,
    u'eng': universitydata.ciu_eng,
    u'ete': universitydata.ciu_ete,
    u'llb': universitydata.ciu_llb,
    u'ranking': universitydata.ciu_ranking

})

uctc_ref = db.collection(u'chittagong').document(u'uctc')

uctc_ref.update({

    u'bba': universitydata.uctc_bba,
    u'mec': universitydata.uctc_mec,
    u'eng': universitydata.uctc_eng,
    u'civil':universitydata.uctc_civil,
    u'cse': universitydata.uctc_cse

})

britania_ref = db.collection(u'chittagong').document(u'britania')

britania_ref.update({

    u'bba': universitydata.britania_bba,
    u'cse': universitydata.britania_cse,
    u'eng': universitydata.britania_eng,
    u'eco': universitydata.britania_eco,
    u'llb': universitydata.britania_llb,
    u'ranking': universitydata.britania_ranking
})


eastwest_ref = db.collection(u'dhaka').document(u'eastwest')

eastwest_ref.update({

    u'bba': universitydata.eastwest_bba,
    u'eco': universitydata.eastwest_eco,
    u'eng': universitydata.eastwest_eng,
    u'socio': universitydata.eastwest_socio,
    u'llb': universitydata.eastwest_llb,
    u'stat': universitydata.eastwest_stat,
    u'ete': universitydata.eastwest_ete,
    u'cse': universitydata.eastwest_cse,
    u'eee': universitydata.eastwest_eee,
    u'pharma': universitydata.eastwest_pharma,
    u'genetic': universitydata.eastwest_genetic,
    u'civil': universitydata.eastwest_civil,
    u'ranking': universitydata.eastwest_ranking
})
daff_ref = db.collection(u'dhaka').document(u'daffodil')

daff_ref.update({

    u'bba': universitydata.daff_bba,
    u'eee': universitydata.daff_eee,
    u'cse': universitydata.daff_cse,
    u'civil': universitydata.daff_civil,
    u'arch': universitydata.daff_arch,
    u'bft': universitydata.daff_bft,
    u'eng': universitydata.daff_eng,
    u'pharma': universitydata.daff_pharma,
    u'tour': universitydata.daff_tour,
    u'llb': universitydata.daff_llb,
    u'journ': universitydata.daff_journ,
    u'ranking': universitydata.daffodil_ranking

})

uiu_ref = db.collection(u'dhaka').document(u'uiu')

uiu_ref.update({

    u'bba': universitydata.uiu_bba,
    u'eco': universitydata.uiu_eco,
    u'cse': universitydata.uiu_cse,
    u'eee': universitydata.uiu_eee,
    u'ranking': universitydata.uiu_ranking
})

edu_ref = db.collection(u'chittagong').document(u'edu')

edu_ref.update({

    u'cse': universitydata.edu_cse,
    u'eee': universitydata.edu_eee,
    u'ete': universitydata.edu_ete,
    u'eco': universitydata.edu_eco,

})


iiuc_ref = db.collection(u'chittagong').document(u'iiuc')

iiuc_ref.update({

    u'cse': universitydata.iiuc_cse

})


victoria_ref = db.collection(u'dhaka').document(u'victoria')

victoria_ref.update({

    u'cse': universitydata.victoria_cse,
    u'bba': universitydata.victoria_bba,
    u'eng': universitydata.victoria_eng


})



nsu_ref = db.collection(u'dhaka').document(u'nsu')

nsu_ref.update({

    u'bba': str(universitydata.nsu_bba),
    u'cse': str(universitydata.nsu_cse),
    u'arch': str(universitydata.nsu_arch),
    u'eng': str(universitydata.nsu_eng),
    u'eee': str(universitydata.nsu_eee),
    u'eco': str(universitydata.nsu_eco),
    u'hrm': str(universitydata.nsu_hrm),
    u'civil': str(universitydata.nsu_civil),
    u'ete': str(universitydata.nsu_ete),
    u'micro': str(universitydata.nsu_micro),
    u'pharma': str(universitydata.nsu_pharma),
    u'environ': str(universitydata.nsu_environ),
    u'biochem': str(universitydata.nsu_biochem),
    u'llb': str(universitydata.nsu_llb),
    u'ranking': universitydata.nsu_ranking
})