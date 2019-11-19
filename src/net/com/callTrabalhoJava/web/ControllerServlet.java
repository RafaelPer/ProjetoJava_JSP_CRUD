package net.com.callTrabalhoJava.web;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.com.callTrabalhoJava.model.Cliente;
import net.com.callTrabalhoJava.dao.ClienteDao;

import net.com.callTrabalhoJava.model.Configuracao;
import net.com.callTrabalhoJava.dao.ConfiguracaoDao;

import net.com.callTrabalhoJava.model.ContaReceber;
import net.com.callTrabalhoJava.dao.ContaReceberDao;

import net.com.callTrabalhoJava.model.Ocorrencias;
import net.com.callTrabalhoJava.dao.OcorrenciasDao;

import net.com.callTrabalhoJava.model.Protocolo;
import net.com.callTrabalhoJava.dao.ProtocoloDao;
/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDao clienteDao;
	private ConfiguracaoDao configuracaoDao;
	private ContaReceberDao contareceberDao;
	private OcorrenciasDao ocorrenciasDao;
	private ProtocoloDao protocoloDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		clienteDao = new ClienteDao();
		configuracaoDao = new ConfiguracaoDao();
		contareceberDao = new ContaReceberDao();
		ocorrenciasDao = new OcorrenciasDao();
		protocoloDao = new ProtocoloDao();
		System.out.println("init: ");
	}
	
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println("action: " + action);

		try {
			switch (action) {
			
			//MANIPULA플O DE CLIENTES
			
			case "/newCliente":
				showNewFormCli(request, response);
				break;
			case "/insertCliente":
				insertCliente(request, response);
				break;
			case "/deleteCliente":
				deleteCliente(request, response);
				break;
			case "/editCliente":
				showEditFormCli(request, response);
				break;
			case "/updateCliente":
				updateCliente(request, response);
				break;
			case "/listCliente":
				listCliente(request, response);
				break;
				
			//MANIPULA플O DE CONFIGURA합ES
			
			case "/newConfiguracao":
				showNewFormConf(request, response);
				break;
			case "/insertConfiguracao":
				insertConfiguracao(request, response);
				break;
			case "/deleteConfiguracao":
				deleteConfiguracao(request, response);
				break;
			case "/editConfiguracao":
				showEditFormConf(request, response);
				break;
			case "/updateConfiguracao":
				updateConfiguracao(request, response);
				break;
			case "/listConfiguracao":
				listConfiguracao(request, response);
				break;
				
			//MANIPULA플O DE CONTA RECEBER
				
			case "/newContaReceber":
				showNewFormContReceb(request, response);
				break;
			case "/insertContaReceber":
				insertContaReceber(request, response);
				break;
			case "/deleteContaReceber":
				deleteContaReceber(request, response);
				break;
			case "/editContaReceber":
				showEditFormContReceb(request, response);
				break;
			case "/updateContaReceber":
				updateContaReceber(request, response);
				break;
			case "/listContaReceber":
				listContaReceber(request, response);
				break;
				
			//MANIPULA플O DE OCORRENCIAS
				
			case "/newOcorrencias":
				showNewFormOcorrencias(request, response);
				break;
			case "/insertOcorrencias":
				insertOcorrencias(request, response);
				break;
			case "/deleteOcorrencias":
				deleteOcorrencias(request, response);
				break;
			case "/editOcorrencias":
				showEditFormOcorrencias(request, response);
				break;
			case "/updateOcorrencias":
				updateOcorrencias(request, response);
				break;
			case "/listOcorrencias":
				listOcorrencias(request, response);
				break;

			//MANIPULA플O DE PROTOCOLOS
				
			case "/newProtocolo":
				showNewFormProtocolo(request, response);
				break;
			case "/insertProtocolo":
				insertProtocolo(request, response);
				break;
			case "/deleteProtocolo":
				deleteProtocolo(request, response);
				break;
			case "/editProtocolo":
				showEditFormProtocolo(request, response);
				break;
			case "/updateProtocolo":
				updateProtocolo(request, response);
				break;
			case "/listProtocolos":
				listProtocolo(request, response);
				break;
			case "/":
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("doPost");
	}
	
	//MANIPULA플O DE CLIENTES
	
	private void listCliente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Cliente> listCliente = clienteDao.selectAllClientes();
		request.setAttribute("listCliente", listCliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormCli(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormCli(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Cliente existingCliente = clienteDao.selectCliente(codigo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cliente-form.jsp");
		request.setAttribute("cliente", existingCliente);
		dispatcher.forward(request, response);

	}

	private void insertCliente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String razao = request.getParameter("razao");
		String fantasia = request.getParameter("fantasia");
		String cnpj = request.getParameter("cnpj");
		String ie = request.getParameter("ie");
		Cliente newCliente = new Cliente(razao, fantasia, cnpj, ie);
		clienteDao.insertCliente(newCliente);
		response.sendRedirect("listCliente");
	}

	private void updateCliente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String razao = request.getParameter("razao");
		String fantasia = request.getParameter("fantasia");
		String cnpj = request.getParameter("cnpj");
		String ie = request.getParameter("ie");

		Cliente cliente = new Cliente(codigo, razao, fantasia, cnpj, ie);
		clienteDao.updateCliente(cliente);
		response.sendRedirect("listCliente");
	}

	private void deleteCliente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		clienteDao.deleteCliente(codigo);
		response.sendRedirect("listCliente");

	}
	
	//MANIPULA플O DE CONFIGURA합ES
	
	private void listConfiguracao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		System.out.println("case listConfiguracao: ");
		List<Configuracao> listConfiguracoes = configuracaoDao.selectAllConfiguracoes();
		request.setAttribute("listConfiguracoes", listConfiguracoes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("configuracao-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormConf(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("configuracao-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormConf(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Configuracao existingConfiguracao = configuracaoDao.selectConfiguracao(codigo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("configuracao-form.jsp");
		request.setAttribute("configuracao", existingConfiguracao);
		dispatcher.forward(request, response);

	}

	private void insertConfiguracao(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String mensagem1 = request.getParameter("mensagem1");
		String mensagem2 = request.getParameter("mensagem2");
		String mensagem3 = request.getParameter("mensagem3");
		String mensagem4 = request.getParameter("mensagem4");
		Configuracao newConfiguracao = new Configuracao(mensagem1, mensagem2, mensagem3, mensagem4);
		configuracaoDao.insertConfiguracao(newConfiguracao);
		response.sendRedirect("listConfiguracao");
	}

	private void updateConfiguracao(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String mensagem1 = request.getParameter("mensagem1");
		String mensagem2 = request.getParameter("mensagem2");
		String mensagem3 = request.getParameter("mensagem3");
		String mensagem4 = request.getParameter("mensagem4");

		Configuracao configuracao = new Configuracao(codigo, mensagem1, mensagem2, mensagem3, mensagem4);
		configuracaoDao.updateConfiguracao(configuracao);
		response.sendRedirect("listConfiguracao");
	}

	private void deleteConfiguracao(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		configuracaoDao.deleteConfiguracao(codigo);
		response.sendRedirect("listConfiguracao");

	}
	
	//MANIPULA플O DE CONTAS A PAGAR
	
	private void listContaReceber(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		System.out.println("case listContReceb: ");
		List<ContaReceber> listContasReceber = contareceberDao.selectAllContasReceber();
		System.out.println("listContReceb: "+listContasReceber);
		request.setAttribute("listContasReceber", listContasReceber);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contareceber-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormContReceb(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("contareceber-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormContReceb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		ContaReceber existingContaReceber = contareceberDao.selectContaReceber(codigo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contareceber-form.jsp");
		request.setAttribute("contareceber", existingContaReceber);
		dispatcher.forward(request, response);

	}

	private void insertContaReceber(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException {
		Date emissao = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("emissao"));
		Date vencimento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("vencimento"));
		Date pagamento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("pagamento"));
		float valor = Float.parseFloat(request.getParameter("valor"));
		ContaReceber contareceber = new ContaReceber(emissao, vencimento, pagamento, valor);
		contareceberDao.insertContaReceber(contareceber);
		response.sendRedirect("listContaReceber");
	}

	private void updateContaReceber(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Date emissao = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("emissao"));
		Date vencimento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("vencimento"));
		Date pagamento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("pagamento"));
		float valor = Float.parseFloat(request.getParameter("valor"));

		ContaReceber contareceber = new ContaReceber(codigo, emissao, vencimento, pagamento, valor);
		contareceberDao.updateContaReceber(contareceber);
		response.sendRedirect("listContaReceber");
	}

	private void deleteContaReceber(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		contareceberDao.deleteContaReceber(codigo);
		response.sendRedirect("listContaReceber");

	}
	
	//MANIPULA플O DE OCORRENCIAS
	
	private void listOcorrencias(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		System.out.println("case listOcorrencias: ");
		List<Ocorrencias> listOcorrencias = ocorrenciasDao.selectAllOcorrencias();
		System.out.println("listOcorrencias: "+listOcorrencias);
		request.setAttribute("listOcorrencias", listOcorrencias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ocorrencias-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormOcorrencias(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ocorrencias-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormOcorrencias(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Ocorrencias existingOcorrencias = ocorrenciasDao.selectOcorrencias(codigo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ocorrencias-form.jsp");
		request.setAttribute("ocorrencias", existingOcorrencias);
		dispatcher.forward(request, response);

	}

	private void insertOcorrencias(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException {
		Date data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data"));
		String nomeUsuario = request.getParameter("nomeUsuario");
		String descricao = request.getParameter("descricao");
		String motivo = request.getParameter("motivo");
		Ocorrencias ocorrencias = new Ocorrencias(data, nomeUsuario, descricao, motivo);
		ocorrenciasDao.insertOcorrencias(ocorrencias);
		response.sendRedirect("listOcorrencias");
	}

	private void updateOcorrencias(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Date data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data"));
		String nomeUsuario = request.getParameter("nomeUsuario");
		String descricao = request.getParameter("descricao");
		String motivo = request.getParameter("motivo");

		Ocorrencias ocorrencias = new Ocorrencias(codigo, data, nomeUsuario, descricao, motivo);
		ocorrenciasDao.updateOcorrencias(ocorrencias);
		response.sendRedirect("listOcorrencias");
	}

	private void deleteOcorrencias(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		ocorrenciasDao.deleteOcorrencias(codigo);
		response.sendRedirect("listOcorrencias");
	}
	
	
	//MANIPULA플O DE PROTOCOLOS
	
	private void listProtocolo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		System.out.println("case listProtocolo: ");
		List<Protocolo> listProtocolos = protocoloDao.selectAllProtocolos();
		System.out.println("listProtocolos: "+listProtocolos);
		request.setAttribute("listProtocolos", listProtocolos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("protocolo-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormProtocolo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("protocolo-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormProtocolo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Protocolo existingProtocolo = protocoloDao.selectProtocolo(codigo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("protocolo-form.jsp");
		request.setAttribute("protocolo", existingProtocolo);
		dispatcher.forward(request, response);

	}

	private void insertProtocolo(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException {
		String problema = request.getParameter("problema");
		String resolucao = request.getParameter("resolucao");
		Date dataAbertura = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataAbertura"));
		Date dataFechamento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataFechamento"));
		Protocolo protocolo = new Protocolo(problema, resolucao, dataAbertura, dataFechamento);
		protocoloDao.insertProtocolo(protocolo);
		response.sendRedirect("listProtocolos");
	}

	private void updateProtocolo(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ParseException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String problema = request.getParameter("problema");
		String resolucao = request.getParameter("resolucao");
		Date dataAbertura = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataAbertura"));
		Date dataFechamento = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dataFechamento"));

		Protocolo protocolo = new Protocolo(codigo, problema, resolucao, dataAbertura, dataFechamento);
		protocoloDao.updateProtocolo(protocolo);
		response.sendRedirect("listProtocolos");
	}

	private void deleteProtocolo(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		protocoloDao.deleteProtocolo(codigo);
		response.sendRedirect("listProtocolos");
	}
}
