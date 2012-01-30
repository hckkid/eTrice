


typedef struct MyActor MyActor;

typedef struct MyActor_const {
	const MyActor* actor;
}MyActor_const;

struct MyActor {
	const MyActor_const* constData;
};

static const MyActor Actor1;
static const MyActor Actor2;

static const MyActor_const Actor1_const = {&Actor1};
static const MyActor_const Actor2_const = {&Actor2};

static const MyActor Actor1 = {&Actor1_const};
static const MyActor Actor2 = {&Actor2_const};;


//*****************************
enum ProtocolName_MsgIds {
	ProtocolName_
};


