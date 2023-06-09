package com.example.exchangecalculatorutils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    ExchangeCalculator e = new ExchangeCalculator();
    final double delta = 1e-6;
    @Test
    public void addition_isCorrect() {
        assertEquals(4, e.Calc("2+2"),delta);
        assertEquals(6, e.Calc("2+2*2"),delta);
        assertEquals(1.0731835024875624, e.Calc("1.036*0.924+0.48*0.134-0.993*0.581/0.938-0.283*0.043/0.849+0.681"),delta);
        assertEquals(0.7361012200729036, e.Calc("0.926*0.464/0.958/0.824*0.111+0.399+0.087*0.325*0.48/0.342+0.237"),delta);
        assertEquals(-1.414696718668495, e.Calc("0.614/0.383-0.18/0.677*0.329+0.142+0.079*0.523-0.603*0.852/0.165"),delta);
        assertEquals(1.2502258553962775, e.Calc("0.08/0.681/0.207*0.032*0.656*0.691/0.68+0.754*0.78-0.249+0.899"),delta);
        assertEquals(0.0534629654574843, e.Calc("0.522*0.249-0.785*0.544+0.024*0.629*0.502*0.374-0.892+0.481/0.388"),delta);
        assertEquals(2.6719465597519627, e.Calc("1.186-0.575*0.114/0.41/0.917*0.471*0.968+0.784+0.952/0.915-0.259"),delta);
        assertEquals(153.4118904872595, e.Calc("1.138+0.586/0.154/0.024-0.442/0.272/0.282-0.316-0.021/0.793-0.171"),delta);
        assertEquals(-1.9277810933804067, e.Calc("0.374+0.355-0.487/0.172*0.916/0.768-0.827-0.44+0.809+0.39/0.331"),delta);
        assertEquals(4.709559269929872, e.Calc("1.778/0.784+0.414/0.442/0.442/0.451*0.349-0.155+0.65*0.649+0.535"),delta);
        assertEquals(-1.3646887107183616, e.Calc("0.198/0.958/0.945-0.515-0.618*0.251*0.918-0.828-0.025-0.504+0.431"),delta);
        assertEquals(-5.624563850556821, e.Calc("1.628+0.467*0.191-0.865/0.113+0.761-0.768-0.4+0.794/0.921-0.142"),delta);
        assertEquals(-3.104844830188679, e.Calc("0.148-0.92*0.23/0.053-0.269+0.196+0.791+0.211*0.464-0.561*0.136"),delta);
        assertEquals(3.5641546143861724, e.Calc("0.224*0.835+0.547/0.217-0.635+0.214*0.497+0.699*0.234+0.353/0.289"),delta);
        assertEquals(2.159995560209424, e.Calc("1.27*0.041/0.955+0.932+0.698+0.23+0.724*0.448-0.202+0.24*0.513"),delta);
        assertEquals(206.43809799331106, e.Calc("0.0/0.778-0.339-0.097+0.247+0.784*0.394/0.023/0.065+0.22*0.035"),delta);
        assertEquals(1.8740184853919566, e.Calc("0.446+0.511/0.951+0.375+0.72+0.026*0.04/0.018/0.349-0.351/0.949"),delta);
        assertEquals(1.0979982385002118, e.Calc("0.108*0.494*0.88+0.748/0.9*0.113/0.089-0.179*0.163/0.872*0.125"),delta);
        assertEquals(0.12703699222126164, e.Calc("0.958*0.159/0.089-0.223-0.33-0.2-0.131/0.065*0.094+0.103-0.745"),delta);
        assertEquals(0.5138519914844967, e.Calc("0.294*0.003/0.523+0.58-0.458-0.168+0.123+0.06*0.483+0.197/0.485"),delta);
        assertEquals(-2.5442002759824085, e.Calc("0.21/0.478*0.273*0.791+0.071*0.97/0.496-0.983/0.751-0.745-0.724"),delta);
        assertEquals(2.522687898090582, e.Calc("0.15*0.126*0.591/0.647/0.685*0.397-0.622+0.518+0.649/0.721/0.344"),delta);
        assertEquals(1.5690108650137742, e.Calc("1.258+0.345+0.541-0.407+0.787+0.682-0.904-0.923*0.688*0.419/0.363"),delta);
        assertEquals(-2.565670822459912, e.Calc("1.506+0.704-0.019-0.957/0.338-0.278*0.772-0.563/0.313+0.075/0.852"),delta);
        assertEquals(3.294391269791119, e.Calc("1.634/0.69+0.226/0.96+0.239+0.835+0.262-0.929+0.075/0.327/0.808"),delta);
        assertEquals(1.5513967281585082, e.Calc("0.658*0.626/0.429+0.005+0.653+0.21*0.906*0.847-0.668*0.934+0.396"),delta);
        assertEquals(1.0954807624578495, e.Calc("0.274-0.184/0.157/0.391*0.214*0.588/0.42+0.404+0.974+0.385*0.887"),delta);
        assertEquals(0.936322541514398, e.Calc("1.57-0.795+0.117*0.767/0.434-0.018*0.681/0.327-0.116+0.082/0.759"),delta);
        assertEquals(-10.696149670065111, e.Calc("1.81-0.512/0.177/0.226+0.382/0.909+0.462-0.282/0.758-0.376+0.159"),delta);
        assertEquals(-0.9582074426589632, e.Calc("1.564-0.885-0.573*0.097+0.282-0.957*0.348-0.614/0.318/0.836+0.779"),delta);
        assertEquals(22.813534293050324, e.Calc("0.756/0.032-0.676/0.299+0.708-0.242-0.036/0.508+0.675+0.391*0.97"),delta);
        assertEquals(9.877758713640892, e.Calc("1.322/0.08*0.587+0.859/0.867-0.144-0.092-0.773-0.401+0.524/0.878"),delta);
        assertEquals(-0.5493188642433233, e.Calc("1.25*0.067+0.211-0.835+0.825*0.255*0.002+0.365*0.632/0.337-0.694"),delta);
        assertEquals(5.048184980425123, e.Calc("1.254+0.792-0.389*0.384+0.515+0.677/0.28/0.953+0.824*0.184*0.656"),delta);
        assertEquals(0.4953388593288125, e.Calc("1.4/0.567/0.284*0.263-0.737-0.74*0.553+0.514-0.824+0.245-0.58"),delta);
        assertEquals(2.7607583547125922, e.Calc("1.872+0.152/0.756-0.56*0.308*0.979-0.134*0.192/0.706+0.597+0.296"),delta);
        assertEquals(1.9878060830449829, e.Calc("0.698+0.405+0.345+0.715*0.884-0.374*0.057-0.728/0.867*0.528*0.16"),delta);
        assertEquals(-0.1231990611488696, e.Calc("1.782*0.455*0.507-0.496*0.881-0.172/0.358*0.374+0.53*0.15/0.965"),delta);
        assertEquals(-0.8777936421459502, e.Calc("1.5*0.506*0.252-0.141+0.919-0.481/0.797-0.57/0.372*0.947*0.857"),delta);
        assertEquals(1.486124906752411, e.Calc("1.1+0.606*0.482/0.933/0.134*0.871-0.403+0.002*0.093-0.47-0.776"),delta);
        assertEquals(1.360826983244289, e.Calc("1.53*0.659+0.051-0.168/0.671-0.656/0.836+0.878+0.767*0.29/0.485"),delta);
        assertEquals(0.8656043157894735, e.Calc("0.97+0.708*0.351+0.669-0.897+0.031+0.81/0.038*0.087*0.178-0.486"),delta);
        assertEquals(446.3077713187147, e.Calc("0.19+0.851/0.41*0.058/0.021+0.524/0.102/0.113/0.17/0.671/0.905"),delta);
        assertEquals(0.5596575217192499, e.Calc("0.158+0.756+0.281+0.277/0.216/0.486*0.048+0.081-0.104-0.911+0.172"),delta);
        assertEquals(1.5717591900000003, e.Calc("1.598*0.513+0.491+0.229+0.67-0.507-0.807*0.946*0.355-0.606+0.746"),delta);
        assertEquals(-0.34836239400000013, e.Calc("0.076-0.888+0.721*0.098*0.507+0.998-0.085-0.044+0.226-0.871*0.766"),delta);
        assertEquals(1.0637215377094795, e.Calc("1.91-0.341/0.884-0.219-0.397-0.439+0.943+0.824-0.887/0.722+0.056"),delta);
        assertEquals(-0.8862358499095839, e.Calc("1.556-0.818-0.634-0.055*0.759+0.202-0.386/0.553-0.118-0.74*0.452"),delta);
        assertEquals(1.4265590427525014, e.Calc("1.864+0.496*0.292/0.281-0.156/0.446*0.672-0.672*0.717-0.343*0.688"),delta);
        assertEquals(1.293695198329854, e.Calc("1.524-0.51-0.24+0.879+0.402-0.55-0.0/0.172-0.653*0.31/0.958"),delta);
        assertEquals(2.963378580631324, e.Calc("1.292+0.607*0.857+0.907/0.545+0.212*0.313*0.679/0.348/0.678-0.704"),delta);
        assertEquals(-0.029817024390243974, e.Calc("1.202-0.513-0.106-0.297/0.738+0.987*0.106-0.957+0.968-0.631+0.305"),delta);
        assertEquals(2.846959721022153, e.Calc("1.868/0.506-0.683-0.789*0.345-0.521+0.703/0.817+0.04-0.416+0.147"),delta);
        assertEquals(0.673998213836478, e.Calc("0.178/0.636-0.706-0.412+0.228+0.822-0.662+0.979*0.756-0.38+0.764"),delta);
        assertEquals(121.93637292923032, e.Calc("1.88/0.928/0.828/0.039/0.508+0.052-0.955-0.074*0.022*0.707-0.655"),delta);
        assertEquals(-29.309348349771874, e.Calc("0.548*0.583*0.753-0.834-0.188+0.127*0.099-0.855-0.25/0.301/0.03"),delta);
        assertEquals(-1.4102376934812695, e.Calc("0.352+0.042-0.718*0.354-0.351*0.644/0.558*0.727-0.945/0.828/0.909"),delta);
        assertEquals(-4.176235035532995, e.Calc("0.348-0.838-0.271-0.822-0.479-0.683-0.489*0.604/0.197+0.986*0.069"),delta);
        assertEquals(0.08977816384123927, e.Calc("0.46/0.786+0.833+0.102+0.389-0.852/0.299*0.696+0.353*0.277/0.597"),delta);
        assertEquals(2.131301802791123, e.Calc("1.444*0.204/0.893+0.866+0.965+0.154-0.615/0.558+0.821+0.238*0.41"),delta);
        assertEquals(-0.47090091583199556, e.Calc("0.532+0.476*0.091/0.886-0.569+0.252*0.914+0.293/0.803-0.856-0.222"),delta);
        assertEquals(2.1778301191915648, e.Calc("1.688-0.095-0.919+0.212/0.415/0.555+0.131+0.867*0.228/0.858+0.222"),delta);
        assertEquals(0.7792478400000001, e.Calc("0.39*0.744*0.241/0.52+0.776+0.007+0.745-0.88-0.939*0.688*0.005"),delta);
        assertEquals(1.8177521119675555, e.Calc("1.08*0.927+0.131/0.9-0.059*0.196*0.113*0.259+0.795*0.725+0.095"),delta);
        assertEquals(0.49646661897674416, e.Calc("0.316*0.519-0.886*0.766*0.441/0.129/0.378*0.468*0.137-0.15+0.876"),delta);
        assertEquals(1.4208539515250367, e.Calc("1.116+0.073/0.443+0.724+0.047-0.622-0.856*0.609*0.732*0.094*0.249"),delta);
        assertEquals(8.057420077925924, e.Calc("0.054*0.275+0.502/0.054*0.938-0.324+0.646*0.444*0.323+0.251-0.697"),delta);
        assertEquals(3.3830940000000003, e.Calc("1.442+0.811+0.388*0.461-0.53*0.357+0.274+0.56+0.12+0.734*0.254"),delta);
        assertEquals(-3.710413103359555, e.Calc("0.93-0.516*0.534/0.887*0.537-0.487/0.107-0.432*0.912*0.267+0.183"),delta);
        assertEquals(-0.4342047161572051, e.Calc("0.982+0.451-0.188-0.458-0.492*0.435-0.744-0.518/0.687*0.895*0.39"),delta);
        assertEquals(2.116459222235294, e.Calc("1.086+0.024/0.425+0.914+0.037+0.417*0.378*0.479-0.22*0.317*0.753"),delta);
        assertEquals(0.8895919154794769, e.Calc("0.256-0.968+0.094/0.034*0.641-0.189*0.613/0.47*0.155-0.083/0.627"),delta);
        assertEquals(0.026760926934526336, e.Calc("0.28-0.548+0.195*0.065/0.285-0.119+0.251+0.787*0.511*0.381*0.772"),delta);
        assertEquals(11.537704011065008, e.Calc("1.304/0.12-0.107-0.354-0.0-0.34*0.394/0.964+0.536+0.997-0.262"),delta);
        assertEquals(0.9865480777312532, e.Calc("0.34-0.867*0.022+0.402/0.511+0.188-0.892*0.207/0.716-0.134*0.382"),delta);
        assertEquals(1.6450663877114524, e.Calc("1.252-0.745+0.852-0.069+0.068/0.185+0.039*0.919/0.834-0.201*0.276"),delta);
        assertEquals(2.757268519271842, e.Calc("1.782*0.276-0.59+0.664+0.717/0.555+0.446*0.984/0.854/0.331-0.653"),delta);
        assertEquals(-4.683719001368023, e.Calc("0.96-0.745-0.69/0.308*0.855/0.783/0.292*0.529+0.007*0.862-0.473"),delta);
        assertEquals(20.53542280638719, e.Calc("1.646/0.929/0.128*0.686*0.51/0.795/0.859-0.195+0.945/0.359/0.193"),delta);
        assertEquals(-2.0452158381051535, e.Calc("0.218-0.742-0.924-0.618+0.244/0.904*0.195*0.257/0.34-0.27+0.251"),delta);
        assertEquals(6.3262192559614325, e.Calc("0.94/0.433+0.034+0.646+0.585+0.995/0.127/0.9/0.68*0.824*0.274"),delta);
        assertEquals(14.872080582577164, e.Calc("1.646-0.931+0.84/0.709+0.682-0.889+0.317/0.699*0.66+0.644/0.05"),delta);
        assertEquals(-22.574875874999996, e.Calc("1.952-0.785*0.33+0.667+0.074*0.944-0.055*0.375*0.227-0.7/0.028"),delta);
        assertEquals(2.667065534767576, e.Calc("0.636+0.882-0.117-0.673-0.009-0.293*0.547+0.98/0.959/0.19*0.392"),delta);
        assertEquals(1.3515306031903018, e.Calc("0.344/0.623/0.6/0.318-0.024/0.615/0.381/0.264*0.346/0.172/0.506"),delta);
        assertEquals(-11.275102242059504, e.Calc("0.274/0.809/0.84/0.653/0.918*0.908-0.895/0.082+0.067*0.191-0.984"),delta);
        assertEquals(2.17841520192471, e.Calc("1.01-0.821/0.716+0.933-0.883/0.302-0.599+0.203/0.022-0.657/0.152"),delta);
        assertEquals(3.642359786674694, e.Calc("1.326-0.208+0.546*0.61+0.734-0.343*0.427+0.235/0.453/0.352+0.13"),delta);
        assertEquals(5.72700807239819, e.Calc("0.352/0.176/0.34/0.78*0.774+0.131*0.515+0.901-0.771-0.457*0.673"),delta);
        assertEquals(0.9672764908462677, e.Calc("0.116/0.68-0.229/0.621/0.331+0.097*0.111+0.876+0.091+0.346+0.587"),delta);
        assertEquals(5.77786771989362, e.Calc("0.274+0.56/0.21/0.367*0.882-0.328/0.254+0.708*0.086/0.345+0.21"),delta);
        assertEquals(0.7459208287633069, e.Calc("0.77-0.599*0.66+0.824/0.244*0.21-0.496*0.4/0.559+0.009+0.008"),delta);
        assertEquals(10.96919344495903, e.Calc("1.72-0.043+0.379+0.871/0.035*0.054/0.401+0.63/0.125+0.087+0.435"),delta);
        assertEquals(1.0463153533967002, e.Calc("1.16/0.921/0.71-0.355*0.912-0.123*0.006*0.898-0.104*0.977/0.252"),delta);
        assertEquals(0.14165342552641627, e.Calc("1.154*0.521*0.78/0.449*0.453/0.774-0.468-0.362/0.379*0.429*0.004"),delta);
        assertEquals(15.685659519369654, e.Calc("1.556*0.023/0.121/0.184+0.436+0.785/0.226/0.365/0.763+0.489+0.681"),delta);
        assertEquals(-0.8560768218068942, e.Calc("1.002-0.016-0.57-0.626*0.642*0.707/0.698*0.971/0.792-0.174-0.599"),delta);
        assertEquals(-6.604374073188231, e.Calc("0.378-0.624-0.709-0.978-0.59/0.113+0.946-0.842+0.381+0.036/0.555"),delta);
        assertEquals(10.750858061292815, e.Calc("1.932/0.724-0.301*0.482*0.893+0.886/0.079*0.711+0.136+0.146*0.698"),delta);
        assertEquals(1.3325430000000003, e.Calc("1.31-0.152-0.698*0.688+0.274-0.655*0.38-0.004+0.5+0.383*0.349"),delta);
    }
}